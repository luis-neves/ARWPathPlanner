package utils.warehouse;

import utils.Graphs.GraphNode;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.LinkedList;

public class PrefabManager {

    public static final float AMPLIFY_Y = 20;
    public static final float AMPLIFY_X = 20;
    private static final Integer PREFAB_RACK = 0;
    private static final Integer PREFAB_STRUCTURE = 1;

    LinkedList prefabList;
    LinkedList<Rack> racks;
    LinkedList<Structure> structures;
    LinkedList<Device> devices;
    LinkedList<Marker> markers;
    LinkedList<Prefab> allPrefabs;
    public Config config;

    public PrefabManager(LinkedList prefabList, Config config) {
        this.prefabList = prefabList;
        this.racks = new LinkedList<>();
        this.structures = new LinkedList<>();
        this.devices = new LinkedList<>();
        this.markers = new LinkedList<>();
        this.config = config;
    }

    public LinkedList<Rack> getRacks() {
        return racks;
    }

    public LinkedList<Structure> getStructures() {
        return structures;
    }

    public LinkedList<Device> getDevices() {
        return devices;
    }

    public LinkedList getPrefabList() {
        return prefabList;
    }

    public void setPrefabList(LinkedList prefabList) {
        this.prefabList = prefabList;
    }

    public Prefab findPrefabID(Integer prefabID) {
        for (Object prefab : prefabList) {
            Prefab pr = (Prefab) prefab;
            if (pr.getId() == prefabID) {
                return pr;
            }
        }
        return null;
    }

    public void addRack(Rack rack) {
        this.racks.add(rack);
    }

    public void addDevice(Device device) {
        this.devices.add(device);
    }

    public void addMarker(Marker marker) {
        this.markers.add(marker);
    }

    public void addStructure(Structure structure) {
        this.structures.add(structure);
    }

    public void changeAxis() {
        fillAllPrefabs();

        float x_max = config.getWidth();
        float y_max = config.getDepth();

        for (Prefab prefab : allPrefabs) {
            Coordenates coords = prefab.getPosition();
            coords.setY(0 - coords.getY());
            prefab.setPosition(coords);
        }

        for (Prefab prefab : allPrefabs) {
            Coordenates coords = prefab.getPosition();
            coords.setY(y_max + coords.getY());
            prefab.setPosition(coords);
        }
    }

    public void fillAllPrefabs() {
        allPrefabs = new LinkedList<>();
        allPrefabs.addAll(racks);
        allPrefabs.addAll(structures);
        allPrefabs.addAll(devices);
        allPrefabs.addAll(markers);
    }

    public HashMap<Integer, LinkedList<Shape>> generateShapes() {
        HashMap<Integer, LinkedList<Shape>> shapes = new HashMap<>();
        LinkedList<Shape> racks = new LinkedList<>();
        LinkedList<Shape> structures = new LinkedList<>();
        for (Prefab prefab : allPrefabs) {
            Rectangle2D rec = new Rectangle(Math.round(prefab.getPosition().getX()), Math.round(prefab.getPosition().getY()), Math.round(prefab.getSize().getX()), Math.round(prefab.getSize().getY()));
            if (prefab.getRotation().hasZvalue()) {
                AffineTransform tx = new AffineTransform();
                tx.rotate(Math.toRadians(360) - Math.toRadians(prefab.getRotation().getZ()), Math.round(prefab.getPosition().getX()), Math.round(prefab.getPosition().getY()));
                Shape newShape = tx.createTransformedShape(rec);
                if (prefab instanceof Rack) {
                    racks.add(newShape);
                }
                if (prefab instanceof Structure) {
                    structures.add(newShape);
                }
                prefab.setShape(newShape);
            } else {
                if (prefab instanceof Rack) {
                    racks.add(rec);
                }
                if (prefab instanceof Structure) {
                    structures.add(rec);
                }
                prefab.setShape(rec);
            }
        }
        shapes.put(PREFAB_RACK, racks);
        shapes.put(PREFAB_STRUCTURE, structures);
        return shapes;
    }

    public void fixSizesToInteger() {
        this.config.setDepth(Math.round(this.config.getDepth() * AMPLIFY_Y));
        this.config.setWidth(Math.round(this.config.getWidth() * AMPLIFY_X));
        fillAllPrefabs();
        for (Object prefab : prefabList) {
            ((Prefab) prefab).getSize().amplifyINT(AMPLIFY_X, AMPLIFY_Y);
        }
        for (Prefab prefab : allPrefabs) {
            ((Prefab) prefab).getPosition().amplifyINT(AMPLIFY_X, AMPLIFY_Y);
        }
    }

    public LinkedList<Prefab> getAllPrefabs() {
        return allPrefabs;
    }

    public Rack findRack(int x, int y, float sensibility) {
        for (int i = 0; i < getRacks().size(); i++) {
            Rack rack = getRacks().get(i);
            if (rack.getShape() != null) {
                int new_x = Math.round((int) rack.getShape().getBounds().getCenterX());
                int new_y = Math.round((int) rack.getShape().getBounds().getCenterY());
                if (x - sensibility < new_x && new_x < x + sensibility) {
                    if (y - sensibility < new_y && new_y < y + sensibility) {
                        return rack;
                    }
                }
            }
        }
        return null;
    }

    public Rack findRackByID(int id) {
        for (Rack rack : racks) {
            if (id == Integer.parseInt(rack.getCode().split("RC")[1])){
                return rack;
            }
        }
        return null;
    }
}

package ga;

import picking.Item;
import utils.Graphs.FitnessNode;
import utils.Graphs.FitnessResults;
import utils.Graphs.Graph;
import utils.Graphs.GraphNode;

import java.util.*;

public abstract class VectorIndividual<P extends Problem, I extends VectorIndividual> extends Individual<P, I> {

    protected Item[] genome;

    public VectorIndividual(P problem, HashMap<GraphNode, List<GraphNode>> items) {
        super(problem);
        List<Item> genomeList = new ArrayList<>();
        for (Map.Entry<GraphNode, List<GraphNode>> entry : items.entrySet()) {
            GraphNode agent = entry.getKey();
            List<GraphNode> agentPath = entry.getValue();
            List<GraphNode> path = new ArrayList<>();
            path.addAll(agentPath);
            Collections.shuffle(path, GeneticAlgorithm.random);
            for (GraphNode node : path){
                genomeList.add(new Item(node));
            }
            genomeList.add(new Item(agent));
        }
        GraphNode lastAgent = genomeList.get(genomeList.size()-1).node;
        GASingleton.getInstance().setLastAgent(lastAgent);
        genomeList.remove(genomeList.size()-1);
        genome = genomeList.toArray(new Item[genomeList.size()]);
    }

    public VectorIndividual(P problem, List<Item> items) {
        super(problem);
        Collections.shuffle(items, GeneticAlgorithm.random);
        genome = items.toArray(new Item[items.size()]);
    }

    public VectorIndividual(VectorIndividual<P, I> original) {
        super(original);
        this.genome = new Item[original.genome.length];
        System.arraycopy(original.genome, 0, genome, 0, genome.length);
    }


    @Override
    public int getNumGenes() {
        return genome.length;
    }

    @Override
    public Item getGene(GraphNode agent, int index) {
        return genome[index];
    }

    private String printTaskedAgents() {
        try {
            String str = "";
            for (Map.Entry<GraphNode, List<FitnessNode>> entry : results.getTaskedAgentsFullNodes().entrySet()) {
                GraphNode agent = entry.getKey();
                List<FitnessNode> agentPath = entry.getValue();
                str += "\n\nAgent " + agent.getType().toLetter() + agent.getGraphNodeId();
                if (!agentPath.isEmpty()) {
                    List<GraphNode> taskedAgentsOnly = results.getTaskedAgentsOnly().get(agent);
                    for (int i = 0; i < taskedAgentsOnly.size(); i++) {
                        str += "\t[" + taskedAgentsOnly.get(i).getType().toLetter() + taskedAgentsOnly.get(i).getGraphNodeId() + "]";
                    }
                    str += " | Steps: " + agentPath.size();
                    if (GASingleton.getInstance().isSimulatingWeights()) {
                        str += "\n\t";
                        for (int i = 0; i < taskedAgentsOnly.size(); i++) {
                            str += "\t[" + (int) taskedAgentsOnly.get(i).getWeightPhysical() + "]";
                        }
                        str += "\tWeight\n\t";
                        for (int i = 0; i < taskedAgentsOnly.size(); i++) {
                            str += "\t[" + (int) taskedAgentsOnly.get(i).getWeightSupported() + "]";
                        }
                        str += "\tSupported Weight\n\t";
                        for (int i = 0; i < this.nodesSupport.get(agent).size(); i++) {
                            str += "\t[" + nodesSupport.get(agent).get(i).intValue() + "]";
                        }
                        str += "\t\tSupporting\n";
                    }

                    str += "\n\tPath: ";
                    for (int i = 0; i < agentPath.size(); i++) {
                        str += "\t[" + agentPath.get(i).getNode().getType().toLetter() + agentPath.get(i).getNode().getGraphNodeId() + "]";
                    }
                    str += "\n\tCost: ";
                    for (int i = 0; i < agentPath.size(); i++) {
                        str += "\t[" + agentPath.get(i).getCost().intValue() + "]";
                    }
                    str += "\n\tTime: ";
                    for (int i = 0; i < agentPath.size(); i++) {
                        str += "\t " + agentPath.get(i).getTime().intValue() + " ";
                    }
                } else {
                    str += "\t Idle";
                }
            }
            str += "\nColisions: ";
            for (int i = 0; i < results.getColisions().size(); i++) {
                str += results.getColisions().get(i).print();
            }
            return str;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public String printGenome() {
        if (GASingleton.getInstance().isNodeProblem()) {
            /*
            String str = "";/*
            for (int i = 0; i < getGenome(-1).length; i++) {
                str += "[" + getGenome(-1)[i].name + "]" + (i == (getGenome(-1).length - 1) ? "" : ",");
            }
            str += ",[" + GASingleton.getInstance().getLastAgent().printName() + "]";
            str += printTaskedAgents();
            return str;
        } else {
            String itemsStr = "";
            String itensAgent = "";
            for (int i = 0; i < genome.length; i++) {
                if (genome[i].cell.getColumn() != -1) {
                    // item
                    if (!itensAgent.equals("")) itensAgent += ", ";
                    itensAgent += genome[i].name;
                    if (i == genome.length - 1) {
                        itemsStr += " \n Agente " + GASingleton.getInstance().getMissingAgentString() + ": " + itensAgent;
                    }
                    continue;
                }
                // agent
                itemsStr += " \n Agente " + genome[i].name + ": " + itensAgent;
                itensAgent = "";

            }*/
        }
        if(results != null){
            return results.printTaskedAgents();
        }else {
            String str = "";
            for (int i = 0; i < getGenome(-1).length; i++) {
                str += "[" + getGenome(-1)[i].name + "]" + (i == (getGenome(-1).length - 1) ? "" : ",");
            }
            str += ",[" + ((GASingleton.getInstance().getLastAgent() != null) ? GASingleton.getInstance().getLastAgent().printName() : "null")+ "]";
            return str;
        }
    }


    public void setGene(GraphNode agent, int index, Item value) {
        genome[index] = value;
    }

    @Override
    public void swapGenes(VectorIndividual other, int index) {
        int auxI = 0;
        for (int i = 0; i < genome.length; i++) {
            if (genome[i].name.equals(other.genome[index].name)) {
                auxI = i;
            }
        }
        Item aux = genome[index];
        Item replace = genome[auxI];
        genome[index] = other.genome[index];
        genome[auxI] = aux;
        for (int i = 0; i < other.genome.length; i++) {
            if (other.genome[i].name.equals(aux.name)) {
                other.genome[i] = replace;
            }
        }
        other.genome[index] = aux;
    }
}

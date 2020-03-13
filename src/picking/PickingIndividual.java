package picking;

import ga.GASingleton;
import ga.VectorIndividual;
import gui.SimulationPanel;
import utils.Graphs.EnvironmentNodeGraph;
import utils.Graphs.FitnessResults;

import java.util.Arrays;
import java.util.List;

public class PickingIndividual extends VectorIndividual<Picking, PickingIndividual> {


    public PickingIndividual(Picking problem, List<Item> items, double prob1s) {
        super(problem, items, prob1s);
    }

    public PickingIndividual(PickingIndividual original) {
        super(original);
    }

    @Override
    public double computeFitness() {
        if (GASingleton.getInstance().isNodeProblem()){
            FitnessResults results = SimulationPanel.environmentNodeGraph.calculatePaths(getGenome());
            fitness = results.getFitness();
            this.results = results;
            fitness += results.getCollisionPenalty() * results.getNumCollisions();

            //System.out.println(results.printTaskedAgents());
            //System.out.println(printGenome() + " - " + fitness);

        } else {
            fitness = 0;
            collisions = 0;
            picksPerAgent = 0;
            List<Double> times = GASingleton.getInstance().setFinalItemSet(Arrays.asList(getGenome()), false);
            int highest = 0;
            if (times != null) {
                for (Double value : times) {
                    if (times.indexOf(value) == times.size() - 1) {
                        picksPerAgent = value;
                    } else if (times.indexOf(value) == times.size() - 2) {
                        collisions = value.intValue();
                    } else {
                        if (highest < value) {
                            highest = value.intValue();
                        }
                    }
                }
                fitness = highest;
            }
        }
        return fitness;
    }

    @Override
    public void swapGenes(PickingIndividual other, int index) {

    }

    @Override
    public void swapGenes(VectorIndividual other, int index) {
        int auxI = 0;
        for (int i = 0; i < genome.length; i++) {
            if (genome[i].name.equals(other.getGenome()[index].name)) {
                auxI = i;
            }
        }
        Item aux = genome[index];
        Item replace = genome[auxI];
        genome[index] = other.getGenome()[index];
        genome[auxI] = aux;
        for (int i = 0; i < other.getGenome().length; i++) {
            if (other.getGenome()[i].name.equals(aux.name)) {
                other.setGene(i, replace);
            }
        }
        other.setGene(index, aux);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nfitness: " + fitness);
        sb.append("\nItems: ");
        sb.append(printGenome());
        //sb.append("\nPicks Per Agent:" + picksPerAgent);

        return sb.toString();
    }

    /**
     * @param i
     * @return 1 if this object is BETTER than i, -1 if it is WORST than I and 0, otherwise.
     */
    @Override
    public int compareTo(PickingIndividual i) {
        return this.fitness == i.getFitness() ? 0 : this.fitness < i.getFitness() ? 1 : -1;
    }

    @Override
    public PickingIndividual clone() {
        return new PickingIndividual(this);
    }

    @Override
    public Item[] getGenome() {
        return this.genome;
    }

    @Override
    public void replaceFromChild(List<Item> genome) {
        this.genome = genome.toArray(this.genome);
    }

    @Override
    public void setGene(Integer index, String value) {
        this.genome[index].setName(value);
    }
}

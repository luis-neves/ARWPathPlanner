package ga.geneticOperators;

import ga.GeneticAlgorithm;
import ga.Individual;
import ga.VectorIndividual;
import picking.HybridPickingIndividual;
import picking.Item;
import utils.Graphs.GraphNode;

public class MutationSwap<I extends Individual> extends Mutation<I> {

    public MutationSwap(double probability) {
        super(probability);
    }

    @Override
    public void run(I individual) {
        int indSize = 0;
        int agent_idx = -1;
        GraphNode agent = null;
        if (individual.getClass().equals(HybridPickingIndividual.class)) {
            int numAgents = individual.getNumGenes();
            agent_idx = GeneticAlgorithm.random.nextInt(numAgents - 1);
            indSize = individual.getNumGenes(agent_idx);
            agent = individual.getAgent(agent_idx);
        } else {
            indSize = individual.getNumGenes();
        }
            int index1, index2 = 0;
            do {
                index1 = GeneticAlgorithm.random.nextInt(indSize);
                index2 = GeneticAlgorithm.random.nextInt(indSize);
            } while (index1 == index2);
            Item item1 = individual.getGene(agent, index1);
            Item item2 = individual.getGene(agent, index2);
            individual.setGene(agent, index2, item1);
            individual.setGene(agent, index1, item2);

    }

    @Override
    public String toString() {
        return "First to Last mutation (" + probability + ")";
    }
}

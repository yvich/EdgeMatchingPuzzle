// Population class
public class Population {
    // Array of puzzle boards
    private PuzzleBoard[] boards;

    // Constructor
    public Population(int size) {
        this.boards = new PuzzleBoard[size];
        for (int i = 0; i < size; i++) {
            this.boards[i] = new PuzzleBoard(rows, columns);
        }
    }

    // Select the fittest puzzle boards from the current population
    public PuzzleBoard[] selectFittest() {
        // Use tournament selection to pick the fittest boards
        PuzzleBoard[] fittest = new PuzzleBoard[k];
        for (int i = 0; i < k; i++) {
            PuzzleBoard best = null;
            for (int j = 0; j < n; j++) {
                PuzzleBoard board = this.boards[random.nextInt(this.boards.length)];
                if (best == null || board.evaluateFitness() > best.evaluateFitness()) {
                    best = board;
                }
            }
            fittest[i] = best;
        }
        return fittest;
    }

    // Reproduce new puzzle boards from the selected fittest boards
    public PuzzleBoard[] reproduce(PuzzleBoard[] fittest) {
        // Use crossover and mutation to produce new boards
        PuzzleBoard[] offspring = new PuzzleBoard[fittest.length];
        for (int i = 0; i < fittest.length; i++) {
            PuzzleBoard parent1 = fittest[i];
            PuzzleBoard parent2 = fittest[(i+1) % fittest.length];
            PuzzleBoard child = parent1.crossover(parent2);
            child.mutate();
            offspring[i] = child;
        }
        return offspring;
    }

    // Evolve the population by repeating the selection and reproduction process
    public void evolve() {
        for (int i = 0; i < this.boards.length; i++) {
            PuzzleBoard[] fittest = this.selectFittest();
            PuzzleBoard[] offspring = this.reproduce(fittest);
            this.boards[i] = offspring[i];
        }
    }
}

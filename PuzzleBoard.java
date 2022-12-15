// PuzzleBoard class
public class PuzzleBoard {
    // ...

    // Crossover with another puzzle board to produce a new configuration
    public PuzzleBoard crossover(PuzzleBoard other) {
        PuzzleBoard child = new PuzzleBoard(this.tiles.length, this.tiles[0].length);
        for (int i = 0; i < this.tiles.length; i++) {
            for (int j = 0; j < this.tiles[i].length; j++) {
                if (random.nextBoolean()) {
                    child.tiles[i][j] = this.tiles[i][j].clone();
                } else {
                    child.tiles[i][j] = other.tiles[i][j].clone();
                }
            }
        }
        return child;
    }

    // ...
}

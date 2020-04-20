public class Sudoku {

    private Cell[][] grid;
    private int size;

    public Sudoku(int[][] grid) {
        size = grid.length;
        this.grid = new Cell[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.grid[i][j] = new Cell(grid[i][j]);
            }
        }
    }


    public void printGrid() {
        System.out.println("-------------------------");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j %3 == 0 )
                    System.out.print("| ");

                if (grid[i][j].getValue() == 0)
                    System.out.print("  ");
                else System.out.print(grid[i][j].getValue() + " ");

            }
            System.out.println("| ");
            if (i%3 == 2)
                System.out.println("-------------------------");
        }
    }

    public void solve() {
        Solver solver = new Solver(this.grid);
        //solver.solve();
    }

}

public class Solver {


    private int size;
    private Cell[][] grid;

    public Solver(Cell[][] sudoku) {
        this.grid = sudoku;
        this.size = grid.length;
    }

    public boolean numberInRow(int row, int number) {
        int i = 0;
        boolean find = false;
        while (!find && i < size - 1) {
            find = grid[row][i].getValue() == number;
            i++;
        }
        return find;
    }

    public boolean numberInCol(int col, int number) {
        int i = 0;
        boolean find = false;
        while (!find && i < size - 1) {
            find = grid[i][col].getValue() == number;
            i++;
        }
        return find;
    }

    public boolean numberInBox(int row, int col, int number) {
        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (grid[i][j].getValue() == number) {
                    return true;
                }
            }
        }
        return false;
    }

}

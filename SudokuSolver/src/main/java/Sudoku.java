public class Sudoku {
    public int[][] SudokuGrid = new int[9][9];

    public Sudoku(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                this.SudokuGrid[i][j] = grid[i][j];
            }
        }
    }

    public void showGrid() {
        System.out.println("Sudoku à résoudre:");
        for (int i = 0; i < this.SudokuGrid.length; i++) {
            if (i % 3 == 0)
                System.out.println(" -------------------------");
            for (int j = 0; j < this.SudokuGrid[i].length; j++) {
                if (j % 3 == 0) System.out.print("| ");
                if (this.SudokuGrid[i][j] != 0){
                    System.out.print(this.SudokuGrid[i][j] + " ");
                }else{
                    System.out.print("  ");
                }

            }
            System.out.println(" |");
        }
        System.out.println(" -------------------------");
    }
}

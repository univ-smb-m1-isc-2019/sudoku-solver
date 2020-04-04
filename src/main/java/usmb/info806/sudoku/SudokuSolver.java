package usmb.info806.sudoku;


public class SudokuSolver
{
    public static void main( String[] args )
    {
        int[][] board = {
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 6, 0, 0, 0, 0, 0},
                {0, 7, 0, 0, 9, 0, 2, 0, 0},
                {0, 5, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 4, 5, 7, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 3, 0},
                {0, 0, 1, 0, 0, 0, 0, 6, 8},
                {0, 0, 8, 5, 0, 0, 0, 1, 0},
                {0, 9, 0, 0, 0, 0, 4, 0, 0}
        };

        int[][] easyBoard = {
                {2, 1, 0, 0, 8, 0, 0, 6, 4},
                {5, 3, 7, 4, 6, 0, 8, 0, 9},
                {0, 0, 6, 0, 3, 1, 0, 0, 0},
                {0, 0, 4, 0, 0, 0, 1, 0, 2},
                {0, 5, 2, 0, 0, 0, 9, 3, 0},
                {3, 0, 1, 0, 0, 0, 7, 0, 0},
                {0, 0, 0, 3, 5, 0, 6, 0, 0},
                {1, 0, 5, 0, 2, 9, 4, 7, 3},
                {9, 7, 0, 0, 1, 0, 0, 2, 8},
        };
        Sudoku sudoku = new Sudoku(easyBoard);
        System.out.println("----------------------------------");
        System.out.println("  On tente de résoudre le Sudoku  ");
        System.out.println("----------------------------------");
        sudoku.solve();
        System.out.println("----------------------------------");
        System.out.println("       Résolution terminée        ");
        System.out.println("----------------------------------");
        sudoku.print();

    }
}

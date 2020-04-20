package fr.jugand.theo.sudoku;

/**
 * Classe représentant l'éxécution du programme
 */
public class Main
{
    public static void main( String[] args )
    {
        //Grille du sudoku
        int[][] grid = {
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

        Sudoku sudoku = new Sudoku(grid);
        if (sudoku.solve()) {
            System.out.println("La grille est résolue");
            sudoku.display();
        } else {
            System.out.println("On ne peut pas résoudre la grille");
        }
    }
}

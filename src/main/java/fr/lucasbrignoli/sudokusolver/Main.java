package fr.lucasbrignoli.sudokusolver;

public class Main {

    private static int[][] board = {
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

    public static void main(String[] args) {
        Sudoku sudokutosolve = new Sudoku(Main.board);
        sudokutosolve.affiche();
        System.out.println();
        long depart = System.currentTimeMillis();
        if(sudokutosolve.resoudre()) {
            sudokutosolve.affiche();
            long fin = System.currentTimeMillis();
            System.out.println("Temps de resolution: " + (fin - depart) + " ms.");
        }else{
            System.out.println("Aucune solution n'a été trouvée.");
        }
    }
}

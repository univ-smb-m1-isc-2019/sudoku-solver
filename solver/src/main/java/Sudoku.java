public class Sudoku {

    /**
     * Constante de la taille de la Grille
     */
    public static final int SIZE = 9;

    /**
     * Grille de sudoku de la classe
     */
    private int[][] board;

    /**
     * Contructeur de la classe Sudoku
     * @param board
     */
    public Sudoku(int[][] board){
        this.board = board;
    }

    /**
     * Méthode vérifiant si un entier se trouve deja dans la ligne
     * @param row
     * @param number
     * @return
     */
    private boolean isInRow(int row, int number) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == number)
                return true;
        }
        return false;
    }


    /**
     * Méthode d'affichage de la grille
     */
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

}

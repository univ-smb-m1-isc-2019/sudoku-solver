package fr.lesageolivier;

public class Sudoku {
    /**
     * Taille de la grille
     */
    public static final int SIZE = 9;

    /**
     * Tableau contenant le Sudoku
     */
    private int[][] board;

    /**
     * Constructeur
     *
     * @param board Tableau contenant les valeur de la grille de jeu
     */
    public Sudoku(int [][] board) {
        this.board = board;
    }

    /**
     * Méthode permettant de savoir si un nombre est dans une ligne
     *
     * @param row Le numéro de la ligne
     * @param number Le nombre dont on veut connaitre la présence
     * @return true si le nombre est présent dans la ligne, false sinon
     */
    private boolean isInRow(int row, int number) {
        for (int i = 0; i < SIZE; i++)
            if (board[row][i] == number)
                return true;

        return false;
    }

    /**
     * Méthode permettant d'afficher la grille
     */
    public void show() {
        for (int[] line: this.board) {
            for (int cell: line) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}

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
     * Méthode permettant de savoir si un nombre est dans une colonne
     *
     * @param col Le numéro de la colonne
     * @param number Le nombre dont on veut connaitre la présence
     * @return true si le nombre est présent dans la colonne, false sinon
     */
    private boolean isInCol(int col, int number) {
        for (int i = 0; i < SIZE; i++)
            if (board[i][col] == number)
                return true;

        return false;
    }

    /**
     * Méthode permettant de savoir si un élément est dans un 3x3
     *
     * @param row Ligne appartenant au 3x3
     * @param col Colonne appartenant au 3x3
     * @param number Le nombre dont on veut connaitre la présence
     * @return true si le nombre est présent dans le 3x3, false sinon
     */
    private boolean isInSub3x3(int row, int col, int number) {
        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (board[i][j] == number)
                    return true;

        return false;
    }

    /**
     * Méthode permettant de savoir si un nombre placé dans la case désignée
     *
     * @param row Ligne dans laquelle on veut placer le nombre
     * @param col Colonne dans laquelle on veut placer le nombre
     * @param number Le nombre que l'on veut placer
     * @return true si le nombre peut être placer dans la case désignée, false sinon
     */
    private boolean canBeHere(int row, int col, int number) {
        return !isInRow(row, number)  &&  !isInCol(col, number)  &&  !isInSub3x3(row, col, number);
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

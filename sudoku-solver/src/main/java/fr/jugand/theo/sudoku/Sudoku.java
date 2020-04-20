package fr.jugand.theo.sudoku;

import java.security.Signature;

/**
 * Classe représentant le sudoku
 */
public class Sudoku {

    /**
     * Grille du sudoku
     */
    private int[][] board;
    /**
     * Taille de la grille
     */
    public final static int SIZE = 9;

    public Sudoku(int[][] board) {
        this.board = board;
    }

    /**
     * Méthode permettant de vérifier si un nombre est dans une rangée
     *
     * @param row    Rangée à vérifier
     * @param number Nombre à vérifier
     * @return Un booléen qui vérifie si le nombre est dans la rangée
     */
    private boolean isInRow(int row, int number) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == number)
                return true;
        }
        return false;
    }

    /**
     * Méthode permettant de vérifier si un nombre est dans une colonne
     *
     * @param col    Colonne à vérifier
     * @param number Nombre à vérifier
     * @return Un booléen qui vérifie si le nombre est dans la colonne
     */
    private boolean isInCol(int col, int number) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == number)
                return true;
        }
        return false;
    }

    /**
     * Méthode permettant de vérifier si un nombre est dans un container 3x3
     *
     * @param row Rangée à vérifier
     * @param col Colonne à vérifier
     * @param number Nombre à vérifier
     * @return Un Booléen si le nombre est dans le container 3x3
     */
    private boolean isInContainer(int row, int col, int number) {
        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == number)
                    return true;
            }
        }
        return false;
    }

    /**
     * Méthode permettant d'afficher la grille
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

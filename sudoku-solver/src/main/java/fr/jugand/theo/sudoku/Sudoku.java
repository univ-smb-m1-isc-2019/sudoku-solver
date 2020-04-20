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
     * @param row Rangée à vérifier
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

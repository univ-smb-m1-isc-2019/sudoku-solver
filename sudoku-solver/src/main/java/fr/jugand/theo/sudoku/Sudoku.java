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
     * Méthode permettant d'afficher la grille
     */
    public void display() {
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}

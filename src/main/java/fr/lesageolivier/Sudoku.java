package fr.lesageolivier;

import java.awt.*;

public class Sudoku {
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

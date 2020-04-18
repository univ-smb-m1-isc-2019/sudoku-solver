package fr.lucasbrignoli.sudokusolver;

public class Sudoku {
    private int LIGNES;
    private int COLONNES;
    public int[][] grille;

    public Sudoku(int[][] grille) {
        this.grille = grille;
        LIGNES = grille.length;
        COLONNES = grille[0].length;
    }

    public void affiche() {
        for (int i = 0; i < LIGNES; i++) {
            for (int j = 0; j < COLONNES; j++) {
                System.out.print(" " + grille[i][j]);
            }

            System.out.println();
        }

        System.out.println();
    }
}

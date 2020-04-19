package fr.lucasbrignoli.sudokusolver;

public class Sudoku {
    private final int LIGNES = 9;
    private final int COLONNES = 9;
    public int[][] grille;

    public Sudoku(int[][] grille) {
        this.grille = grille;
    }

    public boolean estDansLigne(int ligne, int numero) {
        for (int i = 0; i < LIGNES; i++)
            if (grille[ligne][i] == numero)
                return true;

        return false;
    }

    public boolean estDansColonne(int colonne, int numero) {
        for (int i = 0; i < COLONNES; i++)
            if (grille[i][colonne] == numero)
                return true;

        return false;
    }
    public void affiche() {
        for (int i = 0; i < LIGNES; i++) {
            for (int j = 0; j < COLONNES; j++) {
                System.out.print("|" + grille[i][j]);
            }
            System.out.println("|");
        }
    }
}

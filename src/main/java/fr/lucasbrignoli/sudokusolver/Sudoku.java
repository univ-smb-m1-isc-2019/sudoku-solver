package fr.lucasbrignoli.sudokusolver;

public class Sudoku {
    private final int LIGNES = 9;
    private final int COLONNES = 9;
    private final int VIDE = 0;
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
    public boolean estDansBloc(int ligne, int colonne, int numero) {
        int l = ligne - ligne % 3;
        int c = colonne - colonne % 3;

        for (int i = l; i < l + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (grille[i][j] == numero)
                    return true;

        return false;
    }

    public boolean estOk(int ligne, int colonne, int numero) {
        return !estDansLigne(ligne, numero)  &&  !estDansColonne(colonne, numero)  &&  !estDansBloc(ligne, colonne, numero);
    }

    public boolean resoudre() {
        for (int ligne = 0; ligne < LIGNES; ligne++) {
            for (int colonne = 0; colonne < COLONNES; colonne++) {
                if (grille[ligne][colonne] == VIDE) {
                    for (int numero = 1; numero <= LIGNES; numero++) {
                        if (estOk(ligne, colonne, numero)) {
                            grille[ligne][colonne] = numero;

                            if (resoudre()) {
                                return true;
                            } else {
                                grille[ligne][colonne] = VIDE;
                            }
                        }
                    }

                    return false;
                }
            }
        }

        return true;
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

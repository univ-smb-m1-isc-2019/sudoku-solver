public class Solver {

    private int[][] grille;
    public static final int VIDE = 0;
    public static final int TAILLE = 9;

    public Solver(int[][] grille) {
        this.grille = new int[TAILLE][TAILLE];

        // Donner les valeurs de la grille entrée à une grille vide
        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                this.grille[i][j] = grille[i][j];
            }
        }
    }

    public boolean estDansLigne(int ligne, int numero) {
        for (int i = 0; i < TAILLE; i++) {
            if (grille[ligne][i] == numero)
                return true;
        }
        return false;
    }

    public boolean estDansColonne(int colonne, int numero) {
        for (int i = 0; i < TAILLE; i++) {
            if (grille[i][colonne] == numero)
                return true;
        }
        return false;
    }

    public boolean estDansBoite(int ligne, int colonne, int numero) {
        int l = ligne - ligne % 3;
        int c = colonne - colonne % 3;

        for (int i = l; i < l + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (grille[i][j] == numero) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean confirmation(int ligne, int colonne, int numero) {
        return !estDansLigne(ligne, numero) && !estDansColonne(colonne, numero) && !estDansBoite(ligne, colonne, numero);
    }

    public boolean resoudre() {
        for (int ligne = 0; ligne < TAILLE; ligne++) {
            for (int colonne = 0; colonne < TAILLE; colonne++) {
                if (grille[ligne][colonne] == VIDE) {
                    for (int numero = 1; numero < TAILLE; numero++) {
                        if (confirmation(ligne, colonne, numero)) {
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

    public void affichage() {
        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                System.out.print(" " + grille[i][j]);
            }
            System.out.println();
        }
    }

    public int getTaille(){
        return TAILLE;
    }
}


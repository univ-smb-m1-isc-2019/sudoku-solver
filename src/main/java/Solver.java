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

    private boolean estDansLigne(int ligne, int numero) {
        for (int i = 0; i < TAILLE; i++) {
            if (grille[ligne][i] == numero)
                return true;
        }
        return false;
    }

    private boolean estDansColonne(int colonne, int numero) {
        for(int i = 0; i < TAILLE; i++){
            if(grille[i][colonne] == numero)
                return true;
        }
        return false;
    }

    private boolean estDansBoite(int ligne, int colonne, int numero){
        int l = ligne - ligne % 3;
        int c = colonne - colonne % 3;

        for(int i = l; i < l + 3; i++){
            for(int j = c; j < c + 3; j++){
                if(grille[i][j] == numero){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean confirmation(int ligne, int colonne, int numero){
        return !estDansLigne(ligne, numero) && !estDansColonne(colonne, numero) && !estDansBoite(ligne, colonne, numero);
    }

}


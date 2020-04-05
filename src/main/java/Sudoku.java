public class Sudoku {
    public static final int NB_LIGNES   = 9;
    public static final int NB_COLONNES = 9;
    public int[][] grille;


    // Constructeur
    public Sudoku(int[][] grille) {
        this.grille = grille;
    }

    public void afficheGrille()
    {
        for (int i = 0; i < NB_LIGNES; i++) {
            for (int j = 0; j < NB_COLONNES; j++) {
                System.out.print(this.grille[i][j] + " ");
            }
            System.out.println("");
        }
    }

    //Fonction qui vérifie si le nombre est compris entre 0 et 9
    public boolean nombreValide(int nombre){
        if(nombre!=0 && nombre<=9)
            return true;
        return false;
    }
}

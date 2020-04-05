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

    // Fonction qui vérifie si le nombre est compris entre 0 et 9
    public boolean nombreValide(int nombre){
        if(nombre!=0 && nombre<=9)
            return true;
        return false;
    }

    // On vérifie si un nombre est dans une colonne
    public boolean estDansLaColonne(Colonne col, int nombre) {
        for (int i = 0; i < NB_COLONNES; i++)
            if (grille[col.getColonne()][i] == nombre && nombreValide(nombre))
                return true;

        return false;
    }

    // On vérifie si un nombre est dans une ligne
    public boolean estDansLaLigne(Ligne ligne, int nombre) {
        for (int i = 0; i < NB_COLONNES; i++)
            if (grille[i][ligne.getLigne()] == nombre && nombreValide(nombre))
                return true;

        return false;
    }

    // On vérifie si un nombre est dans un carré donné
    public boolean estDansLeCarre(Ligne ligne, Colonne colonne, int nombre) {
        int l = ligne.getLigne() - ligne.getLigne() % 3;
        int c = colonne.getColonne() - colonne.getColonne() % 3;

        for (int i = l; i < l + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (grille[i][j] == nombre && nombreValide(nombre))
                    return true;

        return false;
    }

    // Méthode qui véréfie si un nombre est dans sa bonne ligne, colonne et sont carré
    public boolean estASaPlace(Ligne ligne, Colonne colonne, int nombre)
    {
        return (!estDansLaLigne(ligne, nombre)  &&  !estDansLaColonne(colonne, nombre)  &&  !estDansLeCarre(ligne, colonne, nombre));
    }



    // Méthode qui résoud la grille de sudoku en utilisant estASaPlace jusqu'à ce qu'on est la grille complètée
    public boolean resoudGrille()
    {
        Ligne ligne = new Ligne(0);
        Colonne colonne = new Colonne(0);

        for (int l = 0; l < NB_LIGNES; l++)
        {
            ligne.setLigne(l);
            for (int c = 0; c < NB_COLONNES; c++)
            {
                colonne.setColonne(c);

                // On cherche une case vide
                if (grille[ligne.getLigne()][colonne.getColonne()] == 0)
                {
                    // On test toutes les possibilitées
                    for (int nombre = 1; nombre <= (NB_LIGNES + NB_COLONNES) / 2 ; nombre++)
                    {
                        // Si on trouve sa bonne place on l'affecte à la grille
                        if (estASaPlace(ligne, colonne, nombre))
                        {
                            grille[ligne.getLigne()][colonne.getColonne()] = nombre;

                            // On appel récursivement jusqu'à ce que la grille est complètée
                            if (resoudGrille()) {
                                return true;
                            } else // Si la solution n'est pas bonne, on remet la case libre
                            {
                                grille[ligne.getLigne()][colonne.getColonne()] = 0;

                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }


}

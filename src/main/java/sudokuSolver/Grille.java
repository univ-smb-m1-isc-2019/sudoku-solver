package sudokuSolver;

public class Grille {

    private Case[][] grille;

    public Grille()
    {

    }

    public Case[][] getGrille() {
        return grille;
    }

    public void setGrille(Case[][] grille) {
        this.grille = grille;
    }

    public void setGrille(int l,int c) {
        grille = new Case[l][c];
    }

    public void initGrille(int l, int c)
    {
        setGrille(l,c);
        for(int i = 0; i < l; i++)
        {
            for(int j = 0; j < c; j++)
            {
                grille[i][j] = new Case(i,j);
            }
        }
    }
}

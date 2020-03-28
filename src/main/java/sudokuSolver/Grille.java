package sudokuSolver;

public class Grille {

    private int[][] grille;

    public Grille()
    {

    }

    public int[][] getGrille() {
        return grille;
    }

    public void setGrille(int[][] grille) {
        this.grille = grille;
    }

    public void setGrille(int c,int l) {
        grille = new int[l][c];
    }
}

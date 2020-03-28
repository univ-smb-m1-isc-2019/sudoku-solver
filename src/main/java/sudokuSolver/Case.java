package sudokuSolver;

public class Case {
    private int numeroLigne;
    private int numeroColonne;
    private int valeur;



    public Case(int l, int c)
    {
        setNumeroColonne(c);
        setNumeroLigne(l);
        setValeur(0);
    }

    public int getNumeroLigne() {
        return numeroLigne;
    }

    public void setNumeroLigne(int numeroLigne) {
        this.numeroLigne = numeroLigne;
    }

    public int getNumeroColonne() {
        return numeroColonne;
    }

    public void setNumeroColonne(int numeroColonne) {
        this.numeroColonne = numeroColonne;
    }
    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

}

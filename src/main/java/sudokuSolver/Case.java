package sudokuSolver;

public class Case {
    private int numeroLigne;
    private int numeroColonne;

    public Case(int l, int c)
    {
        setNumeroColonne(c);
        setNumeroLigne(l);
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
}

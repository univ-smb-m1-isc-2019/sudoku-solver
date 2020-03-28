package sudokuSolver;

import java.util.ArrayList;

public class Case {
    private int numeroLigne;
    private int numeroColonne;
    private int valeur;
    ArrayList<Integer> possible;



    public Case(int l, int c)
    {
        setNumeroColonne(c);
        setNumeroLigne(l);
        setValeur(0);
        initPossible();
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
        setPossible(new ArrayList<Integer>());
    }

    public boolean numeroValide()
    {
        return getValeur() >= 0 && getValeur() <= 9;
    }

    public ArrayList<Integer> getPossible() {
        return possible;
    }

    public void setPossible(ArrayList<Integer> possible) {
        this.possible = possible;
    }

    private void initPossible()
    {
        setPossible(new ArrayList<Integer>());
        possible.add(1);
        possible.add(2);
        possible.add(3);
        possible.add(4);
        possible.add(5);
        possible.add(6);
        possible.add(7);
        possible.add(8);
        possible.add(9);
    }

    public boolean encorePossible()
    {
        return possible.size() == 0;
    }

    public void retirePossible(int nb)
    {
        int i = 0;
        boolean stop = false;
        while(i < possible.size() && !stop)
        {
            if(possible.get(i) == nb)
            {
                possible.remove(i);
                stop = true;
            }
            i++;
        }
    }

    public boolean estPossible(int nb)
    {
        int i = 0;
        while(i < possible.size())
        {
            if(possible.get(i) == nb)
            {
                return true;
            }
        }
        return false;
    }

}

package sudokuSolver;

import java.util.ArrayList;

public class Case {
    private int numeroLigne;//Ligne dans laquelle se trouve la case
    private int numeroColonne;//Colonne dans laquelle se trouve la case
    private int valeur;//Valeur de la case
    ArrayList<Integer> possible;//Listes des valeurs possible que peut prendre la case



    public Case(int l, int c, int max)
            //Constructeur de la case
    {
        setNumeroColonne(c);//On indique le numero de la colonne
        setNumeroLigne(l);//On indique le numero de la ligne
        setValeur(0);//On met 0 comme valeur de base a la case
        initPossible(max);//On initialise la liste des valeur possibles
    }

    private void initPossible(int max)
            //On initialise la listes des possibles de la cases
    {
        setPossible(new ArrayList<Integer>());
        for(int i = 1; i <= max; i++)//au debut on ajoutes toutes les possibilitees
        {
            possible.add(i);
        }
    }

    public boolean encorePossible()
            //Verifie qu'il y a encore des possibilitees pour la case
    {
        return possible.size() != 0;
    }

    public void retirePossible(int nb)
            //On retire une possibilitee
    {
        int i = 0;
        boolean stop = false;
        while(i < possible.size() && !stop)
        {
            if(possible.get(i) == nb)//Des qu'on tombe sur la case de la valeur voulu
            {
                possible.remove(i);//On la supprime
                stop = true;
            }
            i++;
        }
    }

    public boolean estPossible(int nb)
            //Verifie qu'un chiffre fait parti des possibilitees
    {
        int i = 0;
        while(i < possible.size())
        {
            if(possible.get(i) == nb)
            {
                return true;
            }
            i++;
        }
        return false;
    }

    public boolean estLibre()
            /*Verifie que la case est libre*/
    {
        return getValeur() == 0;
    }


    /*Getters et Setters*/

    public ArrayList<Integer> getPossible() {
        return possible;
    }

    public void setPossible(ArrayList<Integer> possible) {
        this.possible = possible;
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

    /*Fonction pour les tests*/

    public boolean numeroValide()
            /*Verifie que la valeur de la case est valide*/
    {
        return getValeur() >= 0 && getValeur() <= 9;
    }

    public boolean possibleValide(int max)
            /*Verifie que la taille des possible est valide*/
    {
        return possible.size() == max;
    }

}

package sudokuSolver;

import javafx.util.Pair;

import java.util.ArrayList;

public class Sudoku {
    private int TAILLE_CARRE;

    private Case[][] grille;//Grille du sudoku compose de Cases

    public Sudoku(int l)
    {
        initGrille(l);//Initialisation de la grille avec l lignes et c colonnes
        TAILLE_CARRE = (int) Math.sqrt(l);//Taille d'un carre de la grille
    }

    public void resoudre()
            //Fonction de resolution du sudoku
    {
        boolean erreur;//Booleen qui indique si il y a eu une erreur dans le processus de resolution
        affichage();//On affiche la grille de base
        miseAJourPossible();//On met a jour une premiere fois la liste des possibilites des cases
        while(!resolu())//Tant que le sudoku n'est pas resolu
        {
            erreur = miseAJourCase();//On met a jour une case qui a une seule possibilite
            if(erreur)//Si il y a eu une erreur ou sort du programme
            {
                System.out.println("Erreur, il n'y a pas de case avec une seule possibilitées.");
                System.exit(1);
            }
            miseAJourPossible();//Sinon on met a jour la liste des possibilites des cases

        }
        affichage();//On affiche la grille de fin
    }

    private boolean miseAJourCase()
            //Modifie la valeur de la premiere case qui n'a qu'une possibilite
    {
        for (int i = 0; i < nbLignes(); i++)
        {
            for (int j = 0; j < nbColonnes(); j++)
            {
                //On regarde sur toutes les cases
                if(at(i,j).getPossible().size() == 1)//Quand on en trouve une qui n'a qu'une possibilite
                {
                    at(i,j).setValeur(at(i,j).getPossible().get(0));//On modifie sa valeur avec sa possibilite
                    return false;//On retourne qu'il n'y a pas d'erreur
                }
            }
        }
        return true;//Si aucune case n'avait qu'une possibilite, on retoure qu'il y a une erreur.
    }
    public void miseAJourPossible()
            //Met a jour les valeurs possible pour chaque case
    {
        Case actuelle;
        for(int i = 0; i < nbLignes(); i++)
        {
            for(int j = 0; j < nbColonnes(); j++)
            {
                //On regarde chaque case
                actuelle = at(i,j);
                if(actuelle.estLibre())//Si la case n'a pas de numero
                {
                    if(actuelle.encorePossible()) {//Si sa liste des possibilites n'est pas vide
                        miseAJourLigne(actuelle);//On met a jour les possibilites en fonction de la ligne de la case actuelle
                        miseAJourColonne(actuelle);//On met a jour les possibilites en fonction de la colonne de la case actuelle
                        miseAJourCarre(actuelle);//On met a jour les possibilites en fonction du carre de la case actuelle
                    }
                    else//Si sa liste est vide, c'est qu'il y a une erreur, on sort du programme
                    {
                        System.out.println("Erreur, la case sur a ligne "+actuelle.getNumeroLigne()+" et la colonne "+actuelle.getNumeroColonne() +" n'a plus de possibilites");
                        System.exit(1);

                    }
                }
            }
        }
    }
    private void miseAJourCarre(Case actuelle)
    //Met a jour les possibilites selon le carre auquel appartient la case
    {

        Pair<Integer,Integer> hautGauche = rechercheHautGauche(actuelle);//On cherche les coordonnees de la case la plus en haut a gauche du carre auquel appartient la case actuelle
        Case courante;
        for(int i = 0; i < TAILLE_CARRE; i++)
        {
            for(int j = 0; j < TAILLE_CARRE; j++)
            {
                //On fait autant d'iteration qu'il y a de cases dans le carre
                courante = grille[hautGauche.getKey() + i][hautGauche.getValue() + j];
                //On recupere la case courante en ajoutant le numero de coord de la case la plus en haut a gauche avec le numero de la case ou on se trouve dans le carre
                if(!courante.estLibre())//Si la case contient un numero
                {
                    if(actuelle.estPossible(courante.getValeur()))//Si ce numero est encore dans le liste des cases possible
                    {
                        actuelle.retirePossible(courante.getValeur());//on le retire
                    }
                }
            }
        }

    }

    private void miseAJourColonne(Case actuelle)
            //Met a jour les possibilites selon la colonne auquel appartient la case
    {
        Case courante;
        for(int i = 0; i < nbLignes(); i++)
        {
            //On se balade sur toutes les colonnes
            courante = grille[i][actuelle.getNumeroColonne()];//On recupere la case se situant a ligne actuelle et a la colonne de la case actuelle
            if(!courante.estLibre())//Si la case contient un numero
            {
                if(actuelle.estPossible(courante.getValeur()))//Si ce numero est encore dans le liste des cases possible
                {
                    actuelle.retirePossible(courante.getValeur());//on le retire
                }
            }
        }
    }

    private void miseAJourLigne(Case actuelle)
    //Met a jour les possibilites selon la colonne auquel appartient la case
    {
        Case courante;
        for(int i = 0; i < nbColonnes(); i++)
        {
            courante = grille[actuelle.getNumeroLigne()][i];//On recupere la case se situant a colonne actuelle et a la ligne de la case actuelle
            if(!courante.estLibre())//Si la case contient un numero
            {
                if(actuelle.estPossible(courante.getValeur()))//Si ce numero est encore dans le liste des cases possible
                {
                    actuelle.retirePossible(courante.getValeur());//on le retire
                }
            }
        }
    }

    public void initGrille(int l)
            //Initialise une grille avec une taille l et des cases de base
    {
        setGrille(l);
        for(int i = 0; i < l; i++)
        {
            for(int j = 0; j < l; j++)
            {
                grille[i][j] = new Case(i,j,l);

            }
        }
    }

    private Pair<Integer, Integer> rechercheHautGauche(Case actuelle)
            //Retourne les coordonnees de la case le plus en haut a gauche du carre de la case actuelle
    {
        int ligneDansCarre = actuelle.getNumeroLigne() % 3;
        int colonneDansCarre = actuelle.getNumeroColonne() % 3;
        return new Pair<Integer, Integer>(actuelle.getNumeroLigne() - ligneDansCarre, actuelle.getNumeroColonne() - colonneDansCarre);

    }

    private boolean resolu()
            //Verifie si la grille est resolu ou pas
    {
        for(int i = 0; i < nbLignes(); i++)
        {
            for(int j = 0; j < nbColonnes(); j++)
            {
                //On parcour toutes les cases
                if(at(i,j).estLibre())//Si une case est libre
                {
                    if(!at(i,j).encorePossible())//si elle n'a plus de possibilites il y a eu une erreur donc on sort
                    {
                        System.out.println("Erreur, une case libre n'a plus de possibilitées!");
                        System.exit(1);
                    }else
                    {
                        //Sinon on retourne faux puisqu'il reste une case vide
                        return false;
                    }
                }
            }
        }
        return true;//Si aucune case n'est libre,c'est que le sudoku est fini
    }

    public void affichage()
            //Affichage de la grille
    {
        StringBuilder str = new StringBuilder("      ");
        for(int i = 0; i < nbColonnes(); i++)
        {
            str.append(" ").append(i).append(" ");
        }
        str.append("\n");
        System.out.println(str.toString());

        str = new StringBuilder("");
        for(int i = 0; i < nbLignes(); i++)
        {
            str.append(" ").append(i).append("    ");
            for(int j = 0; j< nbColonnes(); j++)
            {
                str.append("|").append(grille[i][j].getValeur()).append("|");
            }
            System.out.println(str.toString());
            str = new StringBuilder("");
        }

    }

    public void initGrilleJeu1()
        /*Initialisation de la grille avec un jeu trouvé sur internet*/
    {
        /*Ligne numero 0*/
        grille[0][0].setValeur(5);
        grille[0][1].setValeur(3);
        grille[0][4].setValeur(7);
        /*Ligne numero 1*/
        grille[1][0].setValeur(6);
        grille[1][3].setValeur(1);
        grille[1][4].setValeur(9);
        grille[1][5].setValeur(5);
        /*Ligne numero 2*/
        grille[2][1].setValeur(9);
        grille[2][2].setValeur(8);
        grille[2][7].setValeur(6);
        /*Ligne numero 3*/
        grille[3][0].setValeur(8);
        grille[3][4].setValeur(6);
        grille[3][8].setValeur(3);
        /*Ligne numero 4*/
        grille[4][0].setValeur(4);
        grille[4][3].setValeur(8);
        grille[4][5].setValeur(3);
        grille[4][8].setValeur(1);
        /*Ligne numero 5*/
        grille[5][0].setValeur(7);
        grille[5][4].setValeur(2);
        grille[5][8].setValeur(6);
        /*Ligne numero 6*/
        grille[6][1].setValeur(6);
        grille[6][6].setValeur(2);
        grille[6][7].setValeur(8);
        /*Ligne numero 7*/
        grille[7][3].setValeur(4);
        grille[7][4].setValeur(1);
        grille[7][5].setValeur(9);
        grille[7][8].setValeur(5);
        /*Ligne numero 8*/
        grille[8][4].setValeur(8);
        grille[8][7].setValeur(7);
        grille[8][8].setValeur(9);
    }

    public void initGrilleJeu2()
        /*Initialisation de la grille avec un jeu trouvé sur internet.
        * La grille manque de details puisqu'on ne tombe pas sur une case avec une seul possibilite*/
    {
        /*Ligne numero 0*/
        grille[0][1].setValeur(2);
        grille[0][2].setValeur(4);
        grille[0][5].setValeur(5);
        /*Ligne numero 1*/
        grille[1][3].setValeur(1);
        /*Ligne numero 2*/
        grille[2][1].setValeur(9);
        grille[2][5].setValeur(7);
        grille[2][6].setValeur(2);
        grille[2][7].setValeur(3);
        /*Ligne numero 3*/
        grille[3][4].setValeur(4);
        /*Ligne numero 4*/
        grille[4][1].setValeur(5);
        grille[4][3].setValeur(3);
        grille[4][4].setValeur(9);
        grille[4][7].setValeur(2);
        grille[4][8].setValeur(7);
        /*Ligne numero 5*/
        grille[5][0].setValeur(9);
        grille[5][3].setValeur(6);
        grille[5][5].setValeur(2);
        /*Ligne numero 6*/
        grille[6][3].setValeur(5);
        grille[6][7].setValeur(8);
        /*Ligne numero 7*/
        grille[7][0].setValeur(6);
        grille[7][4].setValeur(7);
        /*Ligne numero 8*/
        grille[8][0].setValeur(7);
        grille[8][1].setValeur(1);
        grille[8][7].setValeur(9);
        grille[8][8].setValeur(3);
    }

    /*Getters et Setters*/

    public Case at(int l,int c)
    //Recupere la case a la ligne let la colonne c
    {
        return grille[l][c];
    }

    public int nbLignes()
    //Retourne le nombre de lignes de la grille
    {
        return grille.length;
    }

    public int nbColonnes()
    //Retourne le nombre de colonnes de la grille
    {
        if(nbLignes() < 1)
        {
            return 0;
        }else
        {
            return grille[0].length;
        }
    }

    public void setGrille(int l)
    //Creer la grille de taille l
    {
        grille = new Case[l][l];
    }


    /*Fonction de tests*/

    public boolean bonNumero(Case actuelle)
    {
        boolean ok1, ok2, ok3;
        ok1 = uniqueDansLaLigne(actuelle);
        ok2 = uniqueDansLaColonne(actuelle);
        ok3 = uniqueDansLaCarre(actuelle);

        return ok1 && ok2 && ok3;
    }

    private boolean uniqueDansLaCarre(Case actuelle)
    {
        Pair<Integer,Integer> hautGauche = rechercheHautGauche(actuelle);//On cherche les coordonnees de la case la plus en haut a gauche du carre auquel appartient la case actuelle
        Case courante;
        for(int i = 0; i < TAILLE_CARRE; i++)
        {
            for(int j = 0; j < TAILLE_CARRE; j++)
            {
                //On fait autant d'iteration qu'il y a de cases dans le carre
                courante = grille[hautGauche.getKey() + i][hautGauche.getValue() + j];
                //On recupere la case courante en ajoutant le numero de coord de la case la plus en haut a gauche avec le numero de la case ou on se trouve dans le carre
                if((hautGauche.getKey() + i) != actuelle.getNumeroLigne()
                    && (hautGauche.getValue() + j) != actuelle.getNumeroColonne())
                {
                    if(courante.getValeur() == actuelle.getValeur())
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean uniqueDansLaColonne(Case actuelle)
    {
        Case courante;
        for(int i = 0; i < nbLignes(); i++)
        {
            courante = grille[i][actuelle.getNumeroColonne()];
            if(actuelle.getNumeroLigne() != i)
            {
                if(courante.getValeur() == actuelle.getValeur())
                {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean uniqueDansLaLigne(Case actuelle)
    {
        Case courante;
        for(int i = 0; i < nbColonnes(); i++)
        {
            courante = grille[actuelle.getNumeroLigne()][i];
            if(actuelle.getNumeroColonne() != i)
            {
                if(courante.getValeur() == actuelle.getValeur())
                {
                    return false;
                }
            }
        }
        return true;
    }

}

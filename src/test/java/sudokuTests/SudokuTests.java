package sudokuTests;

import sudokuSolver.Grille;
import org.junit.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SudokuTests {

    @Test
    public void les_cases_doivent_avoir_une_valeur_entre_0_et_9() {
        Grille grille = new Grille();
        grille.initGrille(9,9);
        for(int i = 0; i < grille.nbLignes(); i++)
        {
            for(int j = 0; j < grille.nbColonnes(); j++)
            {
                assertTrue(grille.at(i,j).numeroValide());
            }
        }
        grille.affichage();
        grille.initGrilleJeu1();
        for(int i = 0; i < grille.nbLignes(); i++)
        {
            for(int j = 0; j < grille.nbColonnes(); j++)
            {
                assertTrue(grille.at(i,j).numeroValide());
            }
        }
        grille.affichage();

    }

    @Test
    public void chaque_cases_d_une_grille_vide_a_9_possibilitees()
    {
        Grille grille = new Grille();
        grille.initGrille(9,9);

        for(int i = 0; i < grille.nbLignes(); i++)
        {
            for(int j = 0; j < grille.nbColonnes(); j++)
            {
                assertTrue(grille.at(i,j).possibleValide(9));
                assertTrue(grille.at(i,j).encorePossible());
            }
        }
    }


    @Test
    public void une_case_avec_un_chiffre_n_a_plus_de_possibilitees()
    {
        Grille grille = new Grille();
        grille.initGrille(9,9);
        grille.initGrilleJeu1();

        for(int i = 0; i < grille.nbLignes(); i++)
        {
            for(int j = 0; j < grille.nbColonnes(); j++)
            {
                if(grille.at(i,j).getValeur() == 0) {
                    assertTrue(grille.at(i, j).possibleValide(9));
                    assertTrue(grille.at(i, j).encorePossible());
                }else
                {
                    assertTrue(grille.at(i, j).possibleValide(0));
                    assertFalse(grille.at(i, j).encorePossible());
                }
            }
        }
    }

    @Test
    public void une_case_sans_chiffre_a_des_possibilitees()
    {
        Grille grille = new Grille();
        grille.initGrille(9,9);
        grille.initGrilleJeu1();
        grille.miseAJourPossible();

        for(int i = 0; i < grille.nbLignes(); i++)
        {
            for(int j = 0; j < grille.nbColonnes(); j++)
            {
                if(grille.at(i,j).getValeur() == 0) {
                    assertTrue(grille.at(i, j).encorePossible());
                }else
                {
                    assertFalse(grille.at(i, j).encorePossible());
                }
            }
        }
    }

}

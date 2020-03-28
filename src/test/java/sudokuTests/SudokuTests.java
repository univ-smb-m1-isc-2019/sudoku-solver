package sudokuTests;

import sudokuSolver.Case;
import sudokuSolver.Sudoku;
import org.junit.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SudokuTests {

    @Test
    public void les_cases_doivent_avoir_une_valeur_entre_0_et_9() {
        Sudoku grille = new Sudoku(9);
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
    public void chaque_cases_d_une_grille_vide_a_9_possibilites()
    {
        Sudoku grille = new Sudoku(9);

        for(int i = 0; i < grille.nbLignes(); i++)
        {
            for(int j = 0; j < grille.nbColonnes(); j++)
            {
                assertTrue(grille.at(i,j).possibleValide(9));
                assertTrue(grille.at(i,j).encorePossible());
                assertTrue(grille.at(i,j).numeroValide());
            }
        }
    }

    @Test
    public void une_case_avec_un_chiffre_n_a_plus_de_possibilites()
    {
        Sudoku grille = new Sudoku(9);
        grille.initGrilleJeu1();

        for(int i = 0; i < grille.nbLignes(); i++)
        {
            for(int j = 0; j < grille.nbColonnes(); j++)
            {
                if(grille.at(i,j).getValeur() == 0) {
                    assertTrue(grille.at(i, j).possibleValide(9));
                    assertTrue(grille.at(i, j).encorePossible());
                    assertTrue(grille.at(i, j).numeroValide());
                }else
                {
                    assertTrue(grille.at(i, j).possibleValide(0));
                    assertFalse(grille.at(i, j).encorePossible());
                    assertTrue(grille.at(i, j).numeroValide());
                }
            }
        }
    }

    @Test
    public void une_case_sans_chiffre_a_des_possibilites()
    {
        Sudoku grille = new Sudoku(9);
        grille.initGrilleJeu1();
        grille.miseAJourPossible();

        for(int i = 0; i < grille.nbLignes(); i++)
        {
            for(int j = 0; j < grille.nbColonnes(); j++)
            {
                if(grille.at(i,j).getValeur() == 0) {
                    assertTrue(grille.at(i, j).encorePossible());
                    assertTrue(grille.at(i, j).numeroValide());
                }else
                {
                    assertFalse(grille.at(i, j).encorePossible());
                    assertTrue(grille.at(i, j).numeroValide());
                }
            }
        }
    }

    @Test
    public void les_cases_d_une_grille_resolu_n_ont_plus_de_possibilites()
    {
        Sudoku grille = new Sudoku(9);
        grille.initGrilleJeu1();
        grille.resoudre();
        for(int i = 0; i < grille.nbLignes(); i++)
        {
            for (int j = 0; j < grille.nbColonnes(); j++)
            {
                assertFalse(grille.at(i, j).encorePossible());
                assertTrue(grille.at(i, j).numeroValide());
            }

        }
    }

    @Test
    public void la_resolution_est_bonne()
    {
        Sudoku grille = new Sudoku(9);
        grille.initGrilleJeu1();
        grille.resoudre();

        for(int i = 0; i < grille.nbLignes(); i++)
        {
            for (int j = 0; j < grille.nbColonnes(); j++)
            {
                assertFalse(grille.at(i, j).encorePossible());
                assertTrue(grille.at(i, j).numeroValide());
                assertTrue(grille.bonNumero(grille.at(i, j)));
            }
        }
    }

}

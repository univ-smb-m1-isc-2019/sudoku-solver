import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class testSudokuSolver {
    int[][] grilleATester = {
            { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
            { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
            { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
            { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
            { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
            { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
            { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
            { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
    };

    int[][] grilleComplete = {
            { 8, 1, 2, 7, 5, 3, 6, 4, 9},
            { 9, 4, 3, 6, 8, 2, 1, 7, 5},
            { 6, 7, 5, 4, 9, 1, 2, 8, 3},
            { 1, 5, 4, 2, 3, 7, 8, 9, 6},
            { 3, 6, 9, 8, 4, 5, 7, 2, 1},
            { 2, 8, 7, 1, 6, 9, 5, 3, 4},
            { 5, 2, 1, 9, 7, 4, 3, 6, 8},
            { 4, 3, 8, 5, 2, 6, 9, 1, 7},
            { 7, 9, 6, 3, 1, 8, 4, 5, 2}
    };

    @Test
    public void lesNombresDeLaGrilleVontDe_0_A_9(){
        Sudoku sudoku = new Sudoku(grilleComplete);
        for (int i = 0; i < 9; i++)
        {
            for (int j=0;j<9;j++) {
                assertTrue(sudoku.nombreValide(grilleComplete[i][j]));
            }
        }
    }

    @Test
    public void laLigneEstComplète(){
        Sudoku sudoku = new Sudoku(grilleComplete);
        Ligne ligne = new Ligne(0);
        for (int i = 0; i < 9; i++)
        {
            ligne.setLigne(i);
            for (int j=0;j<9;j++)
            {
                assertTrue(sudoku.estDansLaLigne(ligne,grilleComplete[i][j]));
            }
        }
    }

    @Test
    public void laColonneEstComplète(){
        Sudoku sudoku = new Sudoku(grilleComplete);
        Colonne column = new Colonne(0);
        for (int i = 0; i < 9; i++)
        {
            for (int j=0;j<9;j++)
            {
                column.setColonne(j);
                assertTrue(sudoku.estDansLaColonne(column,grilleComplete[i][j]));
            }
        }
    }

    @Test
    public void UnCarrerEstComplet(){
        Sudoku sudoku = new Sudoku(grilleComplete);
        Colonne colonne = new Colonne(0);
        Ligne ligne = new Ligne(0);
        for (int i = 0; i < 9; i++) {
            ligne.setLigne(i);
            for (int j = 0; j < 9; j++)
            {   colonne.setColonne(j);
                assertTrue(sudoku.estDansLeCarre(ligne,colonne,grilleComplete[i][j]));}
        }
    }

    @Test
    public void testLaGrille() {
        Sudoku sudoku = new Sudoku(grilleATester);
        assertTrue(sudoku.resoudGrille());
    }


}

import fr.lucasbrignoli.sudokusolver.Sudoku;
import org.junit.Test;
import java.io.*;

import static org.junit.Assert.*;

public class SolverTest {
    private static int[][] testboard = {
            {8, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 3, 6, 0, 0, 0, 0, 0},
            {0, 7, 0, 0, 9, 0, 2, 0, 0},
            {0, 5, 0, 0, 0, 7, 0, 0, 0},
            {0, 0, 0, 0, 4, 5, 7, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 3, 0},
            {0, 0, 1, 0, 0, 0, 0, 6, 8},
            {0, 0, 8, 5, 0, 0, 0, 1, 0},
            {0, 9, 0, 0, 0, 0, 4, 0, 0}
    };
    private static int[][] testboard_ligne = {{1,2,3,4,5,6,7,8,0}};
    private static int[][] testboard_colonne = {{1},{2},{3},{4},{5},{6},{7},{8},{0}};
    private static int[][] testboard_bloc = {{1,2,3},{4,5,6},{7,8,0}};
    private static int[][] board_solution = {
            {8,1,2,7,5,3,6,4,9},
            {9,4,3,6,8,2,1,7,5},
            {6,7,5,4,9,1,2,8,3},
            {1,5,4,2,3,7,8,9,6},
            {3,6,9,8,4,5,7,2,1},
            {2,8,7,1,6,9,5,3,4},
            {5,2,1,9,7,4,3,6,8},
            {4,3,8,5,2,6,9,1,7},
            {7,9,6,3,1,8,4,5,2}
    };

    @Test
    public void initialisation_grille() {
        Sudoku sudoku = new Sudoku(testboard);
        assertSame(sudoku.grille, testboard);
    }

    @Test
    public void test_affiche() {
        Sudoku sudoku = new Sudoku(testboard);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        sudoku.affiche();
        String sortie_attendue =
                " 8 0 0 0 0 0 0 0 0\r\n" +
                " 0 0 3 6 0 0 0 0 0\r\n" +
                " 0 7 0 0 9 0 2 0 0\r\n" +
                " 0 5 0 0 0 7 0 0 0\r\n" +
                " 0 0 0 0 4 5 7 0 0\r\n" +
                " 0 0 0 1 0 0 0 3 0\r\n" +
                " 0 0 1 0 0 0 0 6 8\r\n" +
                " 0 0 8 5 0 0 0 1 0\r\n" +
                " 0 9 0 0 0 0 4 0 0\r\n\r\n";
        assertEquals(sortie_attendue,outContent.toString());
    }

    @Test
    public void test_estDansLigne() {
        Sudoku sudoku = new Sudoku(testboard_ligne);
        assertTrue(sudoku.estDansLigne(0,8));
        assertFalse(sudoku.estDansLigne(0,9));
    }

    @Test
    public void test_estDansColonne() {
        Sudoku sudoku = new Sudoku(testboard_colonne);
        assertTrue(sudoku.estDansColonne(0,8));
        assertFalse(sudoku.estDansColonne(0,9));
    }

    @Test
    public void test_estDansBloc(){
        Sudoku sudoku = new Sudoku(testboard_bloc);
        assertTrue(sudoku.estDansBloc(0, 0,8));
        assertFalse(sudoku.estDansBloc(0, 0,9));
    }

    @Test
    public void test_estOk(){
        Sudoku sudoku = new Sudoku(testboard);
        assertTrue(sudoku.estOk(0, 1,1));
    }

    @Test
    public void test_resoudre(){
        Sudoku sudoku = new Sudoku(testboard);
        sudoku.resoudre();
        assertArrayEquals(sudoku.grille, board_solution);
    }

}

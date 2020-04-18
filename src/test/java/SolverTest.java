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

}

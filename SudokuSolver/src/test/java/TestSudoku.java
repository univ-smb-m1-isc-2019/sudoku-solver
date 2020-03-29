import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestSudoku {
    int[][] board = {
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
    public void PossedeTousLesChiffresParLigne() {
        Sudoku sudok = new Sudoku(board);
        sudok.resoudre(0, 0);
        for (int i = 0; i < 9; i++) {
            assertTrue(sudok.possedeTousLesChiffresParLigne(i));
        }
    }

    @Test
    public void PossedeTousLesChiffresParColonne() {
        Sudoku sudok = new Sudoku(board);
        sudok.resoudre(0, 0);
        for (int y = 0; y < 9; y++) {
            assertTrue(sudok.possedeTousLesChiffresParColonne(y));
        }
    }

    @Test
    public void PossedeTousLesChiffresParBloc() {
        Sudoku sudok = new Sudoku(board);
        sudok.resoudre(0, 0);
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                assertTrue(sudok.possedeTousLesChiffresParBloc(x, y));
            }
        }
    }


}


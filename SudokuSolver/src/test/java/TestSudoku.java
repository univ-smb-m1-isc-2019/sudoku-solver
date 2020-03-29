import org.junit.Test;

import static org.junit.Assert.*;

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
    }, fausse_board = {
        { 8, 0, 0, 0, 0, 0, 8, 0, 0 },
        { 0, 0, 3, 6, 0, 0, 0, 0, 9 },
        { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
        { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
        { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
        { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
        { 8, 0, 1, 0, 0, 0, 0, 6, 8 },
        { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
        { 0, 9, 0, 0, 0, 0, 4, 0, 1 }
    };

    @Test
    public void PossedeTousLesChiffresParLigne() {
        Sudoku sudok = new Sudoku(board);
        for (int b = 0; b<20; b++) {
            sudok.resoudre(0, 0);
            for (int i = 0; i < 9; i++) {
                assertTrue(sudok.possedeTousLesChiffresParLigne(i));
            }
        }
    }

    @Test
    public void PossedeTousLesChiffresParColonne() {
        Sudoku sudok = new Sudoku(board);
        for (int i = 0; i<20; i++) {
            sudok.resoudre(0, 0);
            for (int y = 0; y < 9; y++) {
                assertTrue(sudok.possedeTousLesChiffresParColonne(y));
            }
        }
    }

    @Test
    public void PossedeTousLesChiffresParBloc() {
        Sudoku sudok = new Sudoku(board);
        for (int i = 0; i<20; i++) {
            sudok.resoudre(0, 0);
            for (int x = 0; x < 9; x++) {
                for (int y = 0; y < 9; y++) {
                    assertTrue(sudok.possedeTousLesChiffresParBloc(x, y));
                }
            }
        }
    }

    @Test
    public void resolutionEstCorrecte(){
        Sudoku sudok = new Sudoku(board);
        for (int i = 0; i<20; i++) {
            sudok.resoudre(0,0);
            assertTrue(sudok.resolutionCorrecte());
        }
    }

    @Test
    public void solve_should_return_false_if_unsolvable(){
        Sudoku sudok = new Sudoku(fausse_board);
        for (int i = 0; i<20; i++) {
            sudok.resoudre(0,0);
            assertFalse(sudok.resolutionCorrecte());
        }
    }
}


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
        Solver solver = new Solver(board);
        for (int b = 0; b<20; b++) {
            solver.resoudre(0, 0);
            for (int i = 0; i < 9; i++) {
                assertTrue(solver.sudoku.possedeTousLesChiffresParLigne(i));
            }
        }
    }

    @Test
    public void PossedeTousLesChiffresParColonne() {
        Solver solver = new Solver(board);
        for (int i = 0; i<20; i++) {
            solver.resoudre(0, 0);
            for (int y = 0; y < 9; y++) {
                assertTrue(solver.sudoku.possedeTousLesChiffresParColonne(y));
            }
        }
    }

    @Test
    public void PossedeTousLesChiffresParBloc() {
        Solver solver = new Solver(board);
        for (int i = 0; i<20; i++) {
            solver.resoudre(0, 0);
            for (int x = 0; x < 9; x++) {
                for (int y = 0; y < 9; y++) {
                    assertTrue(solver.sudoku.possedeTousLesChiffresParBloc(x, y));
                }
            }
        }
    }

    @Test
    public void resolutionEstCorrecte(){
        Solver solver = new Solver(board);
        for (int i = 0; i<20; i++) {
            solver.resoudre(0,0);
            assertTrue(solver.sudoku.resolutionCorrecte());
        }
    }

    @Test
    public void resolutionIncorrect(){
        Solver solver = new Solver(fausse_board);
        for (int i = 0; i<20; i++) {
            solver.resoudre(0,0);
            assertFalse(solver.sudoku.resolutionCorrecte());
        }
    }
}


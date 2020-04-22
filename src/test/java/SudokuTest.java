import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SudokuTest {

    public static int[][] GRID = {
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

    public static int[][] IMPOSSIBLE_GRID = {
            {8, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 3, 6, 0, 0, 0, 0, 0},
            {0, 7, 0, 0, 9, 0, 2, 0, 0},
            {0, 5, 0, 0, 0, 7, 0, 0, 0},
            {0, 7, 0, 0, 4, 5, 7, 0, 0},    //Erreur ici
            {0, 0, 0, 1, 0, 0, 0, 3, 0},
            {0, 0, 1, 0, 0, 0, 0, 6, 8},
            {0, 0, 8, 5, 0, 0, 0, 1, 0},
            {0, 9, 0, 0, 0, 0, 4, 0, 0}
    };

    Sudoku TEST_GRID = new Sudoku(GRID);
    Sudoku IMPOSSIBLE_TEST_GRID = new Sudoku(IMPOSSIBLE_GRID);

    @Test
    public void number_in_row(){
        Solver solver = new Solver(TEST_GRID.getGrid());
        for (int i = 0; i<100; i++){
            assertTrue(solver.numberInRow(0, 8));
            assertTrue(solver.numberInRow(7, 1));
            assertTrue(solver.numberInRow(8, 4));
            assertFalse(solver.numberInRow(8, 5));
        }
    }

    @Test
    public void number_in_column(){
        Solver solver = new Solver(TEST_GRID.getGrid());
        for (int i = 0; i<100; i++){
            assertTrue(solver.numberInCol(0, 8));
            assertTrue(solver.numberInCol(5, 5));
            assertTrue(solver.numberInCol(7, 6));
            assertFalse(solver.numberInCol(8, 5));
        }
    }

    @Test
    public void number_in_box(){
        Solver solver = new Solver(TEST_GRID.getGrid());
        for (int i = 0; i<100; i++){
            assertTrue(solver.numberInBox(1, 1, 8));
            assertTrue(solver.numberInBox(1, 1, 3));
            assertTrue(solver.numberInBox(1, 1, 7));
            assertTrue(solver.numberInBox(6, 3, 5));
            assertFalse(solver.numberInBox(3, 3, 8));
        }
    }

    @Test
    public void test_solve(){
        assertTrue(TEST_GRID.solve());
        assertFalse(IMPOSSIBLE_TEST_GRID.solve());
    }
}

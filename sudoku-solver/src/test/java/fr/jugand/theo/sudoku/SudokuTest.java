package fr.jugand.theo.sudoku;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuTest {
    public static final int[][] board = {
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

    public static final int[] possibilities = {1, 2, 3, 4, 5, 6, 7, 8, 9};


    private Sudoku sudoku;

    @BeforeEach
    public void createAndResolve() {
        this.sudoku = new Sudoku(SudokuTest.board);
        this.sudoku.solve();
    }

    @Test
    public void testBoardIsComplete() {
        assertTrue(this.sudoku.isComplete());
    }


    @Test
    public void everyNumberFromOneToNineAreInColumnOnce() {
        for (int i = 0; i < Sudoku.SIZE; i++) {
            for (int j = 0; j < Sudoku.SIZE; j++) {
                assertTrue(this.sudoku.columns[i].isInContainer(possibilities[j]));
            }
        }
    }

    @Test
    public void everyNumberFromOneToNineAreInRowOnce() {
        for (int i = 0; i < Sudoku.SIZE; i++) {
            for (int j = 0; j < Sudoku.SIZE; j++) {
                assertTrue(this.sudoku.rows[i].isInContainer(possibilities[j]));
            }
        }
    }

    @AfterEach
    public void displayGrid() {
        this.sudoku.display();
    }

}
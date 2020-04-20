package fr.jugand.theo.sudoku;
import org.junit.Test;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class SudokuTest {

    private Sudoku sudoku;
    @BeforeEach
    public void createAndSolvedGrid(){
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
        sudoku = new Sudoku(board);
        sudoku.solve();
    }

    @Test
    public void gridIsComplete(){
        assertTrue(this.sudoku.isComplete());
    }

    @AfterEach
    public void displaySudoku(){
        this.sudoku.display();
    }
}

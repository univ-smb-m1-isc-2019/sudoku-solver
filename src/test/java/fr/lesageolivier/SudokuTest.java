package fr.lesageolivier;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SudokuTest {
    public static final int[][] board = {
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

    private Sudoku sudoku;

    @BeforeEach
    public void setUp() {
        this.sudoku = new Sudoku(SudokuTest.board);
        this.sudoku.solve();
    }

    @Test
    public void testCalculer() {
        int[][] matrix = this.sudoku.toIntArray();
        assertEquals(matrix.length, Sudoku.SIZE);

        for (int[] line: matrix)
            assertEquals(line.length, Sudoku.SIZE);

        for (int[] line: matrix)
            for(int cell: line)
                assertNotEquals(cell, Cell.EMPTY);
    }
}
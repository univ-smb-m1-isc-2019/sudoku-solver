package com.usmbthomas;

import static com.usmbthomas.Main.board;
import static com.usmbthomas.sudokuBoard.SudokuGrid.GRID_SIZE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.usmbthomas.sudokuBoard.Cell;
import com.usmbthomas.sudokuBoard.SudokuGrid;
import org.junit.Test;

public class SudokuSolverTest
{
    @Test
    public void sudokuGridIsSameAsInputGrid()
    {
        SudokuGrid sudokuGrid = new SudokuGrid(board);

        for (int row = 0; row < GRID_SIZE; ++row) {
            for (int column = 0; column < GRID_SIZE; ++column) {
                assertEquals(sudokuGrid.getCellValue(row, column), board[row][column]);
            }
        }
    }

}

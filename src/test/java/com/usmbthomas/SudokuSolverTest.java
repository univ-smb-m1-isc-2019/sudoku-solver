package com.usmbthomas;

import static com.usmbthomas.Main.board;
import static com.usmbthomas.sudokuBoard.SudokuGrid.GRID_SIZE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.usmbthomas.sudokuBoard.SubGrid;
import com.usmbthomas.sudokuBoard.SudokuGrid;
import com.usmbthomas.sudokuSolver.Sudoku;
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

    @Test
    public void sudokuRowsHasNoDuplicates()
    {
        Sudoku sudoku = new Sudoku(board);
        sudoku.solve();

        for (int row = 0; row < GRID_SIZE; ++row) {
            assertTrue(noDuplicates(sudoku.getGrid().getRow(row)));
        }
    }

    @Test
    public void sudokuColumnsHasNoDuplicates()
    {
        Sudoku sudoku = new Sudoku(board);
        sudoku.solve();

        for (int column = 0; column < GRID_SIZE; ++column) {
            assertTrue(noDuplicates(sudoku.getGrid().getRow(column)));
        }
    }

    @Test
    public void sudokuSquaresHasNoDuplicates()
    {
        Sudoku sudoku = new Sudoku(board);
        sudoku.solve();

        for (int square = 0; square < GRID_SIZE; ++square) {
            assertTrue(noDuplicates(sudoku.getGrid().getRow(square)));
        }
    }

    public boolean noDuplicates(SubGrid subGrid){
        boolean noDuplicates = true;

        for (int i = 0; i < GRID_SIZE; ++i){
            int occurrences = 0;
            for (int j = 0; j < GRID_SIZE; ++j){
                if(i == subGrid.subGridCells[j].getNumber()) occurrences++;
            }
            if (occurrences >= 2) noDuplicates = false;
        }
        return noDuplicates;
    }

}

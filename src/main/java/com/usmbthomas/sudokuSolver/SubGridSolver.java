package com.usmbthomas.sudokuSolver;

import com.usmbthomas.sudokuBoard.SubGrid;
import com.usmbthomas.sudokuBoard.SudokuGrid;

import java.util.Arrays;
import java.util.stream.Stream;

public class SubGridSolver {
    public static Integer[] getAvailableNumbers(SudokuGrid grid, int row, int column){
        SubGrid gridRow = grid.getRow(row);
        SubGrid gridColumn = grid.getColumn(column);
        SubGrid gridSquare = grid.getSquare(row, column);

        Integer[] rowPossibilities = gridRow.availableNumbers();
        Integer[] columnPossibilities = gridColumn.availableNumbers();
        Integer[] squarePossibilities = gridSquare.availableNumbers();

        return compareAvailableNumbers(rowPossibilities, compareAvailableNumbers(columnPossibilities, squarePossibilities));
    }

    public static Integer[] compareAvailableNumbers(Integer[] a, Integer[] b){
        return Stream.of(a)
                .filter(Arrays.asList(b)::contains)
                .toArray(Integer[]::new);
    }
}

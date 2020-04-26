package pack;

import java.util.Arrays;
import java.util.stream.Stream;

//This class permit us to make all the test, using structures made, to know all the possibilities for a given cell.
public class CellSolver {

    public static Integer[] getPossibilities(SudokuGrid grid, int row, int column){
        //Get all the concerned groups for the cell at the row-column indexes into the grid
        CellGroup r = grid.getRow(row);
        CellGroup c = grid.getColumn(column);
        CellGroup s = grid.getSquare(row, column);

        //We get the possibilities for this cell. 3 possibilities, depending on columns-row-square
        Integer[] rowPossibilities = r.getPossibilities();
        Integer[] columnPossibilities = c.getPossibilities();
        Integer[] squarePossibilities = s.getPossibilities();

        //We cross those possibilities to eliminate the wrongs possibilities for this cell
        //At the end, the possibilities contained into the 3 CellGroups are the remaining possibilities.
        return intersection(rowPossibilities, intersection(columnPossibilities, squarePossibilities));
    }
    //This method return an array of int which contains the possibilities contained into a AND b.
    public static Integer[] intersection(Integer[] a, Integer[] b){
        return Stream.of(a)
                .filter(Arrays.asList(b)::contains)
                .toArray(Integer[]::new);
    }
}

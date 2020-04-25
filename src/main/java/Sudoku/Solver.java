package Sudoku;

import java.util.Arrays;
import java.util.stream.Stream;

public class Solver {
    /* get the present values in the line and filter them to keep the missing ones */
    public static Integer[] linePossibleValues(Grid grid, int i){
        Line line = grid.getLines(i);
        Integer[] lineValues = line.getValues();
        return lineValues;
    }
    /* get the present values in the column and filter them to keep the missing ones */
    public static Integer[] colPossibleValues(Grid grid, int j){
        Column col = grid.getColumns(j);
        Integer[] colValues = col.getValues();
        return colValues;
    }
    /* get the present values in the matrix and filter them to keep the missing ones */
    public static Integer[] matPossibleValues(Grid grid, int i, int j){
        Matrice mat = grid.getMatrix(i , j);
        Integer[] matValues = mat.getValues();
        return matValues;
    }

    /* method used to find possible values for a cell by searching the present values in the line, column and matrix */
    public static Integer[] getPossibleValues(Grid grid, int i, int j){
        Integer[] l = linePossibleValues(grid, i);
        Integer[] c = colPossibleValues(grid, j);
        Integer[] m = matPossibleValues(grid, i , j);

        Integer[] res = possibleValues(l, m, c);
        return res;
    }

    /* get all possible values from line/column/matrix and return the possibles values (the ones not present in the line, column, matrix */
    public static Integer[] possibleValues(Integer[] l, Integer[] m, Integer[] c){
        return Stream.of(l)
                .filter(Arrays.asList(m)::contains)
                .filter(Arrays.asList(c)::contains)
                .toArray(Integer[]::new);

    }
}

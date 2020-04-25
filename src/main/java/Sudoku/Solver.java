package Sudoku;

import java.util.Arrays;
import java.util.stream.Stream;

public class Solver {

    public static Integer[] linePossibleValues(Grid grid, int i){
        Line line = grid.getLines(i);
        Integer[] lineValues = line.getValues();
        return lineValues;
    }

    public static Integer[] colPossibleValues(Grid grid, int j){
        Column col = grid.getColumns(j);
        Integer[] colValues = col.getValues();
        return colValues;
    }

    public static Integer[] matPossibleValues(Grid grid, int i, int j){
        Matrice mat = grid.getMatrix(i , j);
        Integer[] matValues = mat.getValues();
        return matValues;
    }

    public static Integer[] getPossibleValues(Grid grid, int i, int j){
        Integer[] l = linePossibleValues(grid, i);
        Integer[] c = colPossibleValues(grid, j);
        Integer[] m = matPossibleValues(grid, i , j);

        Integer[] res = possibleValues(l, m, c);
        return res;
    }

    public static Integer[] possibleValues(Integer[] l, Integer[] m, Integer[] c){
        return Stream.of(l)
                .filter(Arrays.asList(m)::contains)
                .filter(Arrays.asList(c)::contains)
                .toArray(Integer[]::new);

    }
}

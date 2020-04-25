package Sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solver {

    public ArrayList<Integer> linePossibleValues(Grid grid, int i){
        Line line = grid.getLines(i);
        ArrayList<Integer> lineValues = line.getValues();
        return lineValues;
    }

    public ArrayList<Integer> colPossibleValues(Grid grid, int j){
        Column col = grid.getColumns(j);
        ArrayList<Integer> colValues = col.getValues();
        return colValues;
    }

    public ArrayList<Integer> matPossibleValues(Grid grid, int i, int j){
        Matrice mat = grid.getMatrix(i , j);
        ArrayList<Integer> matValues = mat.getValues();
        return matValues;
    }


    public ArrayList<Integer> getPossibleValues(Grid grid, int i, int j){
        ArrayList<Integer> l = linePossibleValues(grid, i);
        ArrayList<Integer> c = colPossibleValues(grid, j);
        ArrayList<Integer> m = matPossibleValues(grid, i , j);

        return possibleValues(l, c, m);




    }

    private ArrayList<Integer> possibleValues(ArrayList<Integer> l, ArrayList<Integer> c, ArrayList<Integer> m) {
        ArrayList<Integer> tmp = (ArrayList<Integer>) c.stream()
                .filter(Arrays.asList(m)::contains);

        return (ArrayList<Integer>) l.stream()
                .filter(Arrays.asList(tmp)::contains);



    }
}

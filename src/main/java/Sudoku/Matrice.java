package Sudoku;

import java.util.ArrayList;

public class Matrice {
    public ArrayList<Cell> matrix;
    //public ArrayList<Integer> values;

    public ArrayList<Cell> getMatrix() {
        return matrix;
    }

    public Matrice() {
        this.matrix = new ArrayList<>();
        getValues();
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();

        for (int i = 1; i < 10; i++){
            values.add(i);
        }

        for (int j = 0; j < matrix.size(); j++){
            values.remove(matrix.get(j).getValue());
        }
        return values;
    }
}

package Sudoku;

import java.util.ArrayList;

public class Matrice {
    public ArrayList<Cell> matrix;

    public Matrice() {
        this.matrix = new ArrayList<>();
    }

    public ArrayList<Cell> getMatrix() {
        return matrix;
    }

    public Integer[] getValues(){
        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 1; i < 10; i++){
            values.add(i);
        }

        for(Cell cell: matrix){
            values.remove(Integer.valueOf(cell.getValue()));
        }

        return values.toArray(new Integer[0]);
    }
}

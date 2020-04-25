package Sudoku;

import java.util.ArrayList;

public class Matrice {
    public ArrayList<Cell> matrix;

    /*    CONSTRUCTOR */
    public Matrice() {
        this.matrix = new ArrayList<>();
    }

    /*  GETTER  */
    public ArrayList<Cell> getMatrix() {
        return matrix;
    }

    /*
    get all values from the matrix and remove the values present
    to keep only the missing ones in possible values
    */
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

package Sudoku;

import java.util.ArrayList;

public class Column {
    public ArrayList<Cell> column;

    /*    CONSTRUCTOR */
    public Column() {
        this.column = new ArrayList<>();
    }

    /*  GETTER */
    public ArrayList<Cell> getColumn() {
        return column;
    }

    /*
    get all values from the column and remove the values present
    to keep only the missing ones in possible values
    */
    public Integer[] getValues(){
        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 1; i < 10; i++){
            values.add(i);
        }

        for(Cell cell: column){
            values.remove(Integer.valueOf(cell.getValue()));
        }

        return values.toArray(new Integer[0]);
    }
}

package Sudoku;

import java.util.ArrayList;

public class Column {
    public ArrayList<Cell> column;

    public Column() {
        this.column = new ArrayList<>();
    }

    public ArrayList<Cell> getColumn() {
        return column;
    }

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

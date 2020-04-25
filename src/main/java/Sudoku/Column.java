package Sudoku;

import java.util.ArrayList;

public class Column {
    public ArrayList<Cell> column;
    public ArrayList<Integer> values;

    public Column() {
        this.column = new ArrayList<>();
        getValues();
    }

    private void getValues() {
        this.values = new ArrayList<>();

        for (int i = 1; i < 10; i++){
            this.values.add(i);
        }

        for (int j = 0; j < column.size(); j++){
            values.remove(column.get(j).getValue());
        }
    }
}

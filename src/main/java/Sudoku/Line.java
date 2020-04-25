package Sudoku;

import java.util.ArrayList;

public class Line {
    public ArrayList<Cell> line;
    public ArrayList<Integer> values;

    public Line() {
        this.line = new ArrayList<>();
        getValues();
    }

    public ArrayList<Integer> getValues() {
        this.values = new ArrayList<>();

        for (int i = 1; i < 10; i++){
            this.values.add(i);
        }

        for (int j = 0; j < line.size(); j++){
            values.remove(line.get(j).getValue());
        }
        return values;
    }

}

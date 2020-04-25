package Sudoku;

import java.util.ArrayList;

public class Line {
    public ArrayList<Cell> line;

    public Line() {
        this.line = new ArrayList<>();
    }

    public ArrayList<Cell> getLine() {
        return line;
    }

    public Integer[] getValues(){
        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 1; i < 10; i++){
            values.add(i);
        }

        for(Cell cell: line){
            values.remove(Integer.valueOf(cell.getValue()));
        }

        return values.toArray(new Integer[0]);
    }

}

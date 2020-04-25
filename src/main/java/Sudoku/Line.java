package Sudoku;

import java.util.ArrayList;

public class Line {
    public ArrayList<Cell> line;

    /*    CONSTRUCTOR */
    public Line() {
        this.line = new ArrayList<>();
    }

    /*  GETTER */
    public ArrayList<Cell> getLine() {
        return line;
    }

    /*
    get all values from the line and remove the values present
    to keep only the missing ones in possible values
    */
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

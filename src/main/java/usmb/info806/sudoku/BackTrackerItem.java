package usmb.info806.sudoku;

import java.util.ArrayList;

public class BackTrackerItem {
    public Sudoku sudoku;
    public int value;
    public int maximum;
    public int cellID;

    public BackTrackerItem(Sudoku sudoku, int value, int maximum, int cellID){
        this.sudoku = new Sudoku();
        this.sudoku.cellList = new ArrayList<Cell>();
        sudoku.cellList.stream().forEach(elt->{
            this.sudoku.cellList.add(new Cell(elt.value, elt.x, elt.y));
        });
        this.value = value;
        this.maximum = maximum;
        this.cellID = cellID;
    }

    public boolean update(){
        if(this.value < maximum){
            this.value++;
            return true;
        }else{
            return false;
        }
    }
}

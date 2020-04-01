package usmb.info806.sudoku;


import java.util.ArrayList;

public class Line extends CellContainer{


    public Line(int id) {
        cellList = new ArrayList<Cell>();
        this.id = id;
    }
}

package usmb.info806.sudoku;

import java.util.ArrayList;

public class Square extends CellContainer {
    public Square(int id) {
        cellList = new ArrayList<Cell>();
        this.id = id;
    }
}

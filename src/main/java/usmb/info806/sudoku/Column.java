package usmb.info806.sudoku;

import java.util.ArrayList;

public class Column extends CellContainer {
    public Column(int id) {
        cellList = new ArrayList<Cell>();
        this.id = id;
    }
}

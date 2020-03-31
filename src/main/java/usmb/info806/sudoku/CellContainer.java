package usmb.info806.sudoku;

import java.util.ArrayList;

public class CellContainer {
    public ArrayList<Cell> cellList;
    public int id;

    public CellContainer(){
        this.cellList = new ArrayList<Cell>();
    }
    public CellContainer(ArrayList<Cell> List){
        this.cellList = List;
    }

}

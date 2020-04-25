package usmb.info806.sudoku;

import java.util.ArrayList;

public class CellContainer {
    public ArrayList<Cell> cellList;
    public int id;

    public CellContainer(){
        this.cellList = new ArrayList<Cell>();
    }


    public Possibility getAvailablePossibilility(){
        Possibility possibility = new Possibility();
        this.cellList.stream().forEach(elt ->{
            if(elt.value != 0){
                possibility.availablePossibility[elt.value-1]=false;
            }
        });
        return possibility;
    }
    public Possibility getAvailablePossibilility(Possibility possibility){
        this.cellList.stream().forEach(elt ->{
            if(elt.value != 0){
                possibility.availablePossibility[elt.value-1]=false;
            }
        });
        return possibility;
    }



}

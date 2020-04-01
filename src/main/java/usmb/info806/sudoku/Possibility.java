package usmb.info806.sudoku;

import java.util.ArrayList;

public class Possibility {
    public ArrayList<Integer> availablePossibility;

    public Possibility(){
    availablePossibility = new ArrayList<Integer>();
    addAllPosibility();
    }

    public void checkCellList(ArrayList<Cell> cellList){
        for (Cell cell: cellList) {
            if (cell.value != 0){
                availablePossibility.remove(cell.value);
            }
        }
    }

    public void addAllPosibility(){
        availablePossibility.add(1);
        availablePossibility.add(2);
        availablePossibility.add(3);
        availablePossibility.add(4);
        availablePossibility.add(5);
        availablePossibility.add(6);
        availablePossibility.add(7);
        availablePossibility.add(8);
        availablePossibility.add(9);
    }
}

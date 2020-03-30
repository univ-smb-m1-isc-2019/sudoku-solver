package com.usmbthomas.sudokuBoard;

import java.util.ArrayList;
import java.util.Arrays;

public class SubGrid {
    private Cell[] subGridCells;

    public SubGrid(Cell[] cells) {
        initSubGrid();
    }

    private void initSubGrid() {
        for (Cell cell : subGridCells) cell.setNumber(0);
   }

    public ArrayList<Integer> numbersAvailable(){
        ArrayList<Integer> numbersAvailable = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        for(Cell cell: subGridCells){
            numbersAvailable.remove(Integer.valueOf(cell.getNumber()));
        }

        return numbersAvailable;
    }

}

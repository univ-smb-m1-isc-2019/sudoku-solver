package com.usmbthomas.sudokuBoard;

import java.util.ArrayList;
import java.util.Arrays;

public class SubGrid {
    private Cell[] subGridCells = new Cell[SudokuGrid.GRID_SIZE];

    public SubGrid() {
        initSubGrid();
    }

    private void initSubGrid() {
        for (int i = 0; i < SudokuGrid.GRID_SIZE; ++i) {
            Cell cell = new Cell();
            this.subGridCells[i] = cell;
        }
   }

    public ArrayList<Integer> availableNumbers(){
        ArrayList<Integer> numbersAvailable = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        for(Cell cell: subGridCells){ numbersAvailable.remove(Integer.valueOf(cell.getNumber())); }

        return numbersAvailable;
    }

    public void updateCell(int cellIndex, int cellValue){
        subGridCells[cellIndex].setNumber(cellValue);
    }

/*    public String toString(){
        StringBuilder sBuilder = new StringBuilder();

        for(int row = 0; row < SudokuGrid.GRID_SIZE; ++row) {
            sBuilder.append(subGridCells[row]);
            sBuilder.append("  ");
        }
        return sBuilder.toString();
    }*/

}

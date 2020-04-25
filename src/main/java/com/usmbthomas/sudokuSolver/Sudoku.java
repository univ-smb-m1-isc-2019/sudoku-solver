package com.usmbthomas.sudokuSolver;

import com.usmbthomas.sudokuBoard.Cell;
import com.usmbthomas.sudokuBoard.SudokuGrid;

import static com.usmbthomas.sudokuBoard.SudokuGrid.GRID_SIZE;

public class Sudoku {
    private SudokuGrid grid;

    public Sudoku(int[][] board){
        this.grid = new SudokuGrid(board);
    }

    public boolean solve(){
        for(int row = 0; row < GRID_SIZE; ++row) {
            for (int column = 0; column < GRID_SIZE; ++column) {
                Cell cell = grid.getCell(row, column);

                if(cell.isEmpty()) {
                    System.out.println("Row["+ row +"]  Column["+ column +"]");

                    Integer[] possibilities = SubGridSolver.getAvailableNumbers(grid, row, column);

                    for (Integer possibility : possibilities) {
                        cell.setNumber(possibility);

                        if (solve()) {
                            return true;
                        }
                        else{
                            cell.setNumber(0);
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    public String toString(){
        return grid.toString();
    }

}

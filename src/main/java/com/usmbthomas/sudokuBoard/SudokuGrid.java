package com.usmbthomas.sudokuBoard;

public class SudokuGrid {
    private static final int GRID_SIZE = 9;
    private Cell[][] grid = new Cell[GRID_SIZE][GRID_SIZE];

    public SudokuGrid(int[][] grid) {

        for (int row = 0; row < GRID_SIZE; ++row) {
            for (int column = 0; column < GRID_SIZE; ++column) {
                Cell cell = new Cell(grid[row][column]);
                this.grid[row][column]= cell;
            }
        }
    }

    public String toString(){
        StringBuilder sBuilder = new StringBuilder();

        for(int row = 0; row < GRID_SIZE; ++row) {
            for (int column = 0; column < GRID_SIZE; ++column) {
                sBuilder.append(grid[row][column]);
                sBuilder.append("  ");
            }
            sBuilder.append("\n");
        }
        return sBuilder.toString();
    }

}

package com.usmbthomas.sudokuBoard;

import java.util.ArrayList;

public class SudokuGrid {
    public static final int GRID_SIZE = 9;
    private Cell[][] grid = new Cell[GRID_SIZE][GRID_SIZE];
    private SubGrid[] rows = new SubGrid[GRID_SIZE];
    private SubGrid[] columns = new SubGrid[GRID_SIZE];
    private SubGrid[] squares = new SubGrid[GRID_SIZE];


    public SudokuGrid(int[][] grid) {
        initRows();
        initColumns();
        initSquares();
        initGrid(grid);
    }

    private void initGrid(int[][] grid) {

        for (int row = 0; row < GRID_SIZE; ++row) {
            for (int column = 0; column < GRID_SIZE; ++column) {
                Cell cell = new Cell(grid[row][column]);
                this.grid[row][column] = cell;
                this.rows[row].updateCell(column, cell);
                this.columns[column].updateCell(row, cell);
                int squaresIndex = getSquaresIndex(row, column);
                this.squares[squaresIndex].updateCell(column, cell);
            }
        }

    }

    private void initRows() {
        for (int column = 0; column < GRID_SIZE; ++column) {
            this.rows[column] = new SubGrid();
        }
    }

    private void initColumns() {
        for (int row = 0; row < GRID_SIZE; ++row) {
            this.columns[row] = new SubGrid();
        }
    }

    private void initSquares() {
        for(int square = 0; square < GRID_SIZE; ++square){
            this.squares[square] = new SubGrid();
        }
    }

    private int getSquaresIndex(int row, int column) {
        return (row / 3) * 3 + (column / 3);
    }



    public int getCellValue(int row, int column){
        return this.grid[row][column].getNumber();
    }

    public Cell getCell(int row, int column) { return grid[row][column]; }

    public SubGrid getRow(int rowIndex){
        return rows[rowIndex];
    }

    public SubGrid getColumn(int colIndex){
        return columns[colIndex];
    }

    public SubGrid getSquare(int row, int column){
        int index = getSquaresIndex(row, column);
        return squares[index];
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

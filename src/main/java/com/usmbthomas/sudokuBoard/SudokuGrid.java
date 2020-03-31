package com.usmbthomas.sudokuBoard;

import java.util.ArrayList;

public class SudokuGrid {
    public static final int GRID_SIZE = 9;
    private Cell[][] grid = new Cell[GRID_SIZE][GRID_SIZE];
    private SubGrid[] rows = new SubGrid[GRID_SIZE];
    private SubGrid[] columns = new SubGrid[GRID_SIZE];
    private SubGrid[] squares = new SubGrid[GRID_SIZE];


    public SudokuGrid(int[][] grid) {
        initGrid(grid);
        initRows(grid);
        initColumns(grid);
        initSquares(grid);
    }

    private void initGrid(int[][] grid) {
        for (int row = 0; row < GRID_SIZE; ++row) {
            for (int column = 0; column < GRID_SIZE; ++column) {
                Cell cell = new Cell(grid[row][column]);
                this.grid[row][column] = cell;
            }
        }
    }

    private void initRows(int[][] grid) {
        for (int column = 0; column < GRID_SIZE; ++column) {
            this.rows[column] = new SubGrid();
            for (int row = 0; row < GRID_SIZE; ++row) {
                this.rows[column].updateCell(row, grid[column][row]);
            }
        }
    }

    private void initColumns(int[][] grid) {
        for (int row = 0; row < GRID_SIZE; ++row) {
            this.columns[row] = new SubGrid();
            for (int column = 0; column < GRID_SIZE; ++column) {
                this.columns[row].updateCell(column, grid[column][row]);
            }
        }
    }

    private void initSquares(int[][] grid) {
        ArrayList<Cell>[] squaresArray = new ArrayList[GRID_SIZE];
        for(int i = 0; i < GRID_SIZE; ++i) squaresArray[i] = new ArrayList<>();
        for(int row = 0; row < GRID_SIZE; ++row){
            for(int column = 0; column < GRID_SIZE; ++column){
                int squareIndex = getSquareIndex(row, column);
                squaresArray[squareIndex].add(new Cell(grid[row][column]));
            }
        }
        for(int i = 0; i < GRID_SIZE; ++i){
            this.squares[i] = new SubGrid(squaresArray[i]);
        }
    }

    private int getSquareIndex(int row, int column) {
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
        int index = getSquareIndex(row, column);
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

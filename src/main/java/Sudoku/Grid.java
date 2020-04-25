package Sudoku;

import java.util.Arrays;

public class Grid {
    private Cell[][] grid;
    private Line[] lines;
    private Column[] columns;
    private Matrice[] matrix;

    public Cell getCell(int i, int j){
        return grid[i][j];
    }

    public Line getLines(int i) {
        return lines[i];
    }

    public Column getColumns(int i) {
        return columns[i];
    }

    public Matrice getMatrix(int i, int j) {
        return matrix[(i/3)*3 + (j/3)];
    }

    public Matrice getMatrix(int i){
        return matrix[i];
    }

    public Grid(int[][] grid) {
        initEmptyGrid();
        createGrid(grid);
    }

    private void initEmptyGrid(){
        initLines();
        initColumns();
        initMatrice();
    }

    private void initLines(){
        this.lines = new Line[9];

        for(int i = 0; i < 9; ++i){
            lines[i] = new Line();
        }
    }

    private void initColumns(){
        this.columns = new Column[9];

        for(int j = 0; j < 9; ++j){
            columns[j] = new Column();
        }
    }

    private void initMatrice(){
        this.matrix = new Matrice[9];

        for(int k = 0; k < 9; ++k){
            matrix[k] = new Matrice();
        }
    }

    public String toString(){
        StringBuilder s = new StringBuilder();

        for(int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                s.append(grid[i][j]);
                s.append("  ");
            }
            s.append("\n");
        }

        return s.toString();
    }

    private void createGrid(int[][] board){
        this.grid = new Cell[9][9];

        for(int i = 0; i < 9; ++i){
            for(int j = 0; j < 9; ++j){
                Cell cell = new Cell(board[i][j]);

                this.grid[i][j] = cell;
                this.lines[i].line.add(cell);
                this.columns[j].column.add(cell);
                this.matrix[(i/3)*3 + (j/3)].matrix.add(cell);
            }
        }
    }
}

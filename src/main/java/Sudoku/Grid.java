package Sudoku;

import java.util.Arrays;

public class Grid {
    private Cell[][] grid;
    private Line[] lines;
    private Column[] columns;
    private Matrice[] matrix;

    /*  GETTER */
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

    /*    CONSTRUCTOR */
    public Grid(int[][] grid) {
        initEmptyGrid();
        createGrid(grid);
    }

    /* methods used to create an empty grid with empty lines/columns/matrix  */
    private void initEmptyGrid(){
        initLines();
        initColumns();
        initMatrice();
    }

    private void initLines(){
        this.lines = new Line[Sudoku.SIZE];

        for(int i = 0; i < Sudoku.SIZE; ++i){
            lines[i] = new Line();
        }
    }

    private void initColumns(){
        this.columns = new Column[Sudoku.SIZE];

        for(int j = 0; j < Sudoku.SIZE; ++j){
            columns[j] = new Column();
        }
    }

    private void initMatrice(){
        this.matrix = new Matrice[Sudoku.SIZE];

        for(int k = 0; k < Sudoku.SIZE; ++k){
            matrix[k] = new Matrice();
        }
    }

    /* display the grid */
    public String toString(){
        StringBuilder s = new StringBuilder();

        for(int i = 0; i < Sudoku.SIZE; ++i) {
            for (int j = 0; j < Sudoku.SIZE; ++j) {
                s.append(grid[i][j]);
                s.append("  ");
            }
            s.append("\n");
        }

        return s.toString();
    }

    private void createGrid(int[][] board){
        this.grid = new Cell[Sudoku.SIZE][Sudoku.SIZE];

        for(int i = 0; i < Sudoku.SIZE; ++i){
            for(int j = 0; j < Sudoku.SIZE; ++j){
                Cell cell = new Cell(board[i][j]);

                this.grid[i][j] = cell;
                this.lines[i].line.add(cell);
                this.columns[j].column.add(cell);
                this.matrix[(i/3)*3 + (j/3)].matrix.add(cell);
            }
        }
    }
}

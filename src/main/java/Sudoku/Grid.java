package Sudoku;

import java.util.Arrays;

public class Grid {
    public Cell[][] grid;
    public Line[] lines;
    public Column[] columns;
    public Matrice[] matrix;

    public Cell getCell(int i, int j ) {
        return grid[i][j];
    }

    public Line getLines(int i) {
        return lines[i];
    }

    public Column getColumns(int j) {
        return columns[j];
    }

    public Matrice getMatrix(int i, int j) {
        return matrix[(i/3)*3 + (j/3)];
    }

    public Grid(int[][] grid) {
        initGrid(grid);
    }

    private void initGrid(int[][] grid) {
        createGrid(grid);
    }

    @Override
    public String toString() {
        return "Grid{" +
                "grid=" + Arrays.toString(grid) +
                '}';
    }

    private void createGrid(int[][] grid) {
        initLines();
        initColumns();
        initMatrice();
        this.grid = new Cell[9][9];
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                Cell cell = new Cell(grid[i][j]);
                int posMatrix = (i/3)*3 + (j/3);
                this.grid[i][j] = cell;
                this.lines[i].line.add(cell);
                this.columns[i].column.add(cell);
                this.matrix[posMatrix].matrix.add(cell);

            }
        }

    }

    private void initLines() {
        this.lines = new Line[9];
        for (int i = 0; i < 9; i++){
            lines[i] = new Line();
        }
    }

    private void initColumns() {
        this.columns = new Column[9];
        for (int i = 0; i < 9; i++){
            columns[i] = new Column();
        }
    }

    private void initMatrice() {
        this.matrix = new Matrice[9];
        for (int i = 0; i < 9; i++){
            matrix[i] = new Matrice();
        }
    }

    public void solver() {
    }
}

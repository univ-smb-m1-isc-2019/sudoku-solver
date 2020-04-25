package Sudoku;

public class Grid {
    public Cell[][] grid;
    public Line[] lines;
    public Column[] columns;
    public Matrice[] matrix;


    public Grid(int[][] grid) {
        initGrid(grid);
    }

    private void initGrid(int[][] grid) {
        initLines();
        initColumns();
        initMatrice();

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

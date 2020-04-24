package Sudoku;

public class Grid {
    private Cell[][] grid;

    public Grid(Cell[][] grid) {
        this.grid = grid;
    }

    public Grid() {
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void setGrid(Cell[][] grid) {
        this.grid = grid;
    }

    public void setFirstCase(int nLine, int nCol){
        grid = new Cell[nLine][nCol];
    }

    public void initGrid(int nbLine, int nbCol){
        setFirstCase(nbLine,nbCol);
        for(int i = 0; i < nbLine; i++) {
            for (int j = 0; j < nbCol; j++) {
                grid[i][j] = new Cell(i,j);
            }
        }

    }
}

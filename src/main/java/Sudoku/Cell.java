package Sudoku;

public class Cell {
    private int nLine;
    private int nCol;

    public Cell(int nLine, int nCol) {
        this.nLine = nLine;
        this.nCol = nCol;
    }

    public int getnLine() {
        return nLine;
    }

    public void setnLine(int nLine) {
        this.nLine = nLine;
    }

    public int getnCol() {
        return nCol;
    }

    public void setnCol(int nCol) {
        this.nCol = nCol;
    }
}

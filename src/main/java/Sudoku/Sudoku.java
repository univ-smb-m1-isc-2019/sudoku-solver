package Sudoku;

public class Sudoku {
    public Grid board;

    public Sudoku(int[][] board){
        this.board = new Grid(board);
    }

    @Override
    public String toString() {
        return board.toString();
    }

    public void solver() {
    }
}

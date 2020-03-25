package baptistediot;

import baptistediot.board.Board;

public class Sudoku {
    public static final int ROW_SIZE = 9;
    public static final int COLUMN_SIZE = 9;
    public static final int SQUARE_SIZE = 9;

    private Board sudoku;

    public Sudoku(int[][] board){
        this.sudoku = new Board(board);
    }

    public void solve(){

    }

    public String toString(){
        return sudoku.toString();
    }
}

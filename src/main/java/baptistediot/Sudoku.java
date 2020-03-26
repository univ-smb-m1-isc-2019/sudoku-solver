package baptistediot;

import baptistediot.board.Board;
import baptistediot.board.Cell;

import java.util.Arrays;

public class Sudoku {
    public static final int ROW_SIZE = 9;
    public static final int COLUMN_SIZE = 9;
    public static final int SQUARE_SIZE = 9;

    private Board board;

    public Sudoku(int[][] board){
        this.board = new Board(board);
    }

    public void solve(){
    }

    public String toString(){
        return board.toString();
    }

    public Board getBoard(){
        return board;
    }
}

package baptistediot;

public class Sudoku {
    public static final int ROW_SIZE = 9;
    public static final int COLUMN_SIZE = 9;
    public static final int SQUARE_SIZE = 9;

    public Board sudoku;

    public Sudoku(int[][] board){
        this.sudoku = new Board(board);
    }

    public void solve(){

    }
}

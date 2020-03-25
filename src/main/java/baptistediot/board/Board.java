package baptistediot.board;

public class Board {
    public Cell[][] board;
    public Row[] rows;
    public Column[] columns;
    public Square[] squares;


    public Board(int[][] board) {
        buildBoard(board);
    }

    private void buildBoard(int[][] board){

    }
}

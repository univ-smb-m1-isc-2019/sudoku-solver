public class Sudoku {

    private int[][] board;
    public static final int EMPTY=0;//Empty cell
    public static final int SIZE=9;//the size of our Sudoku grids


    public Sudoku(int[][] board) {
        this.board = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.board[i][j] = board[i][j];
            }
        }
    }


}

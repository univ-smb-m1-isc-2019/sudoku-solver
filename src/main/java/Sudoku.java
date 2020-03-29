public class Sudoku {

    private int[][] board;
    public static final int FREE=0;//free cell
    public static final int GRID_SIZE=9;//the size of our Sudoku grids

    //creates the board
    public Sudoku(int[][] board) {
        this.board = new int[GRID_SIZE][GRID_SIZE];

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                this.board[i][j] = board[i][j];
            }
        }
    }


    // we check if a possible number is already in a row
    private boolean isInRow(int row, int number) {
        for (int i = 0; i < GRID_SIZE; i++)
            if (board[row][i] == number)
                return true;

        return false;
    }

    // we check if a possible number is already in a column
    private boolean isInColumn(int col, int number) {
        for (int i = 0; i < GRID_SIZE; i++)
            if (board[i][col] == number)
                return true;

        return false;
    }

    // we check if a possible number is in its 3x3 box
    private boolean isInBox(int row, int column, int number) {
        int r = row - row % 3;
        int c = column - column % 3;

        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (board[i][j] == number)
                    return true;

        return false;
    }

    // combined method to check if a number possible to a row,column position is ok
    private boolean numberOk(int row, int col, int number) {
        return !isInRow(row, number)  &&  !isInColumn(col, number)  &&  !isInBox(row, col, number);
    }

    // Solve method
    public boolean solve() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                //search for a free cell
                if (board[row][column] == FREE) {
                    // try all possible numbers
                    for (int number = 1; number <= GRID_SIZE; number++) {
                        if (numberOk(row, column, number)) {
                            //if the number is ok. we add it to the board
                            board[row][column] = number;

                            if (solve()) { // we solve recursively
                                return true;
                            } else { // if the solution is not okay, the cell is emptied and we continue
                                board[row][column] = FREE;
                            }
                        }
                    }

                    return false; // we return false
                }
            }
        }

        return true; // when the sudoku is solved we return true
    }

}

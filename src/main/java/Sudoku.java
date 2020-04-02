import java.sql.Struct;

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

    public boolean numberIsOk(int number){
        if(number!=0 && number<=9)
            return true;
        return false;
    }
    // we check if a possible number is already in a row
    public boolean isInRow(int row, int number) {
        for (int i = 0; i < GRID_SIZE; i++)
            if (board[row][i] == number && numberIsOk(number))
                return true;

        return false;
    }

    // we check if a possible number is already in a column
    public boolean isInColumn(Column column, int number) {
        for (int i = 0; i < GRID_SIZE; i++)
            if (board[i][column.getColumn()] == number && numberIsOk(number))
                return true;

        return false;
    }

    // we check if a possible number is in its 3x3 square
    public boolean isInSquare(int row, Column column, int number) {
        int r = row - row % 3;
        int c = column.getColumn() - column.getColumn() % 3;

        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (board[i][j] == number && numberIsOk(number))
                    return true;

        return false;
    }

    // combined method to check if a number possible to a row,column position is ok
    public boolean numberOk(int row, Column col, int number) {
        return !isInRow(row, number)  &&  !isInColumn(col, number)  &&  !isInSquare(row, col, number);
    }

    // Solve method
    public boolean solve() {
        Column col=new Column(0);

        for (int row = 0; row < GRID_SIZE; row++) {
                                for (int column = 0; column < GRID_SIZE; column++) {
                                    //search for a free cell
                                    col.setColumn(column);
                                    
                                    if (board[row][col.getColumn()] == FREE) {
                                        // try all possible numbers
                                        for (int number = 1; number <= GRID_SIZE; number++) {
                                            if (numberOk(row, col, number)) {
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

    //displays the input grid
    public void displayGrid() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print(" " + board[i][j]);
            }

            System.out.println();
        }

        System.out.println();
    }



}

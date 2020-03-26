package baptistediot;

import baptistediot.board.Board;
import baptistediot.board.Cell;

public class Sudoku {
    public static final int ROW_SIZE = 9;
    public static final int COLUMN_SIZE = 9;
    public static final int SQUARE_SIZE = 9;

    private Board board;

    public Sudoku(int[][] board){
        this.board = new Board(board);
    }

    public boolean solve(){
        for(int row = 0; row < ROW_SIZE; ++row) {
            for (int column = 0; column < COLUMN_SIZE; ++column) {
                Cell cell = board.getCell(row, column);

                if(cell.isEmpty()) {

                    Integer[] possibilities = CellSolver.getPossibilities(board, row, column);

                    for (Integer possibility : possibilities) {
                        cell.setValue(possibility);

                        if (solve()) {
                            return true;
                        }
                        else{
                            cell.setValue(0);
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    public String toString(){
        return board.toString();
    }

    public Board getBoard(){
        return board;
    }
}

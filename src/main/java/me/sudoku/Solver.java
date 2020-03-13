package me.sudoku;


public class Solver {
    Board board;
    public Solver(int[][] initBoard){
        board = new Board(initBoard);
    }
    public void solve(){
        reducePossibleValues();
        board.printBoard();
    }

    public void reducePossibleValues(){
        for (int i = 0; i<board.length; i++){
            for (int j = 0; j<board.length; j++){
                Cell c = board.board[i][j];
                if (!c.isResolved()){
                    reduceFromLine(c);
                    reduceFromCol(c);
                }
            }
        }
    }
    public void reduceFromLine(Cell c){
        for (int i = 0; i<board.length; i++) {
            int value = board.board[c.getLine()][i].getValue();
            if (c.getPossibleValues().contains(value)){
                c.removePossibleValue(value);
            }
        }
    }
    public void reduceFromCol(Cell c){
        for (int i = 0; i<board.length; i++) {
            int value = board.board[i][c.getCol()].getValue();
            if (c.getPossibleValues().contains(value)){
                c.removePossibleValue(value);
            }
        }
    }
}

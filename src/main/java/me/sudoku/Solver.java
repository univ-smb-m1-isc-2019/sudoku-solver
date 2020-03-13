package me.sudoku;


public class Solver {
    Board board;
    public Solver(int[][] initBoard){
        board = new Board(initBoard);
    }
    public void solve(){
        //reducePossibleValues();
        board.printBoard();
    }

    /*public void reducePossibleValues(){
        for (int i = 0; i<board.length; i++){
            for (int j = 0; j<board.length; j++){
                Cell c = board.board[i][j];
                if (!c.isResolved()){
                    reduceFromLine(c);
                    reduceFromCol(c);
                    if (c.getPossibleValues().size() == 1){
                        c.setValue(c.getPossibleValues().get(0));
                        c.resolved();
                    }
                }
            }
        }
    }*/
    public boolean numberIsInLine(int line, int number){
        for (int i = 0; i<board.length; i++) {
            if (board.board[line][i].getValue() == number){
                return true;
            }
        }
        return false;
    }
    public boolean numberIsInCol(int col, int number){
        for (int i = 0; i<board.length; i++) {
            if (board.board[i][col].getValue() == number){
                return true;
            }
        }
        return false;
    }

}

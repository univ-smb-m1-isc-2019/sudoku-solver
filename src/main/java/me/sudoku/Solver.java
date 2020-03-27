package me.sudoku;


public class Solver {
    Board board;
    public Solver(int[][] initBoard){
        board = new Board(initBoard);
    }
    public boolean solve(){
        for (int i = 0; i<board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board.board[i][j].getValue() == 0) {
                    for (int num = 1; num <= board.length; num++) {
                        if (!numberIsInLine(i, num)
                                &&  !numberIsInCol(j, num)
                                &&  !numberIsInArea(i, j, num)) {
                            board.board[i][j].setValue(num);
                            if (solve()) {
                                return true;
                            } else {
                                board.board[i][j].setValue(0);
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

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
    public boolean numberIsInArea(int line, int col, int number){
        int l = line - line % 3;
        int c = col - col % 3;
        for (int i = l; i < l + 3; i++){
            for (int j = c; j < c + 3; j++){
                if (board.board[i][j].getValue() == number){
                    return true;
                }
            }
        }
        return false;
    }
}

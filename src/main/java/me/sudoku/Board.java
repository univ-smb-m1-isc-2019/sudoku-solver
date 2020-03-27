package me.sudoku;


public class Board {
    Cell[][] board;
    int length;
    Board(int[][] board){
        length = board.length;
        this.board = new Cell[board.length][board.length];
        for (int i = 0; i<board.length; i++){
            for (int j = 0; j<board.length; j++){
                this.board[i][j] = new Cell(board[i][j]);
            }
        }
    }
    void printBoard(){
        for (int i = 0; i<board.length; i++){
            for (int j = 0; j<board.length; j++){
                String val = board[i][j].getValue() == 0 ? " " : Integer.toString(board[i][j].getValue());
                System.out.print(val + " ");
                if (j == 2 || j == 5)
                    System.out.print("| ");
            }
            System.out.print("\n");
            if (i == 2 || i == 5)
                System.out.println("- - - - - - - - - - -");
        }
    }
}

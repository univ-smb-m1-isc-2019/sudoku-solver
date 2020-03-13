package me.sudoku;

public class Board {
    Cell[][] board;

    Board(int[][] board){
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
                System.out.print(board[i][j].getValue() + " ");
            }
            System.out.print("\n");
        }
    }
}

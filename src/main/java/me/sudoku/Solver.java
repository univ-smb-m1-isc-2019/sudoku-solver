package me.sudoku;

import java.util.Arrays;

public class Solver {
    Board board;
    public Solver(int[][] initBoard){
        board = new Board(initBoard);
    }
    public void solve(){
        board.printBoard();
    }

    
}

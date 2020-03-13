package me.sudoku;

import java.util.Arrays;

public class Solver {
    void solve(int[][] initBoard){
        Board board = new Board(initBoard);
        board.printBoard();
    }


}

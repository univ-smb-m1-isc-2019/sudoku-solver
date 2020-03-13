package me.sudoku;

import java.util.Arrays;

public class Solver {
    void solve(int[][] board){
        Cell[][] boardCells = createBoardCells(board);
        printBoard(boardCells);
    }
    Cell[][] createBoardCells(int[][] board){
        Cell[][] res = new Cell[board.length][board.length];
        for (int i = 0; i<board.length; i++){
            for (int j = 0; j<board.length; j++){
                res[i][j] = new Cell(board[i][j]);
            }
        }
        return res;
    }
    void printBoard(Cell[][] board){
        for (int i = 0; i<board.length; i++){
            for (int j = 0; j<board.length; j++){
                System.out.print(board[i][j].getValue() + " ");
            }
            System.out.print("\n");
        }
    }
}

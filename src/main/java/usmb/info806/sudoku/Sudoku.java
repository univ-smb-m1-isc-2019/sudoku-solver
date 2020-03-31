package usmb.info806.sudoku;

import java.util.ArrayList;

public class Sudoku {
    public ArrayList<Cell> cellList;

    public Sudoku(int[][] board){
        cellList = new ArrayList<Cell>();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                cellList.add(new Cell(board[i][j], i, j));
            }
        }
    }
}

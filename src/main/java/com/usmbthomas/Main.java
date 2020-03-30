package com.usmbthomas;
import com.usmbthomas.sudokuBoard.SubGrid;
import com.usmbthomas.sudokuBoard.SudokuGrid;

import java.util.ArrayList;

public class Main
{
    public static int[][] board = {
            { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
            { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
            { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
            { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
            { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
            { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
            { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
            { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
    };

    public static void main( String[] args )
    {


        SudokuGrid sudokuGrid = new SudokuGrid(board);
        System.out.println(sudokuGrid);

        System.out.println(sudokuGrid.getRows(1));
        System.out.println(sudokuGrid.getColumns(1));
        System.out.println(sudokuGrid.getSquares(2));


/*        SubGrid sub = new SubGrid();
        sub.updateCell(1, 1);
        sub.updateCell(2, 2);
        sub.updateCell(4, 3);
        ArrayList<Integer> num = new ArrayList<>(sub.availableNumbers());
        System.out.println(sub);
        System.out.println(num);*/



    }
}

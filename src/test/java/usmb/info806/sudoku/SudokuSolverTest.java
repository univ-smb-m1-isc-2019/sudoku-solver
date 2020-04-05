package usmb.info806.sudoku;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;


public class SudokuSolverTest
{

    @Test
    public void lineShouldHaveEveryNumber(){
        int[][] board = SudokuSolver.easyBoard;
        Sudoku sudoku = new Sudoku(board);
        sudoku.solve();
        Integer[] allPossibleNumber = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (Line line: sudoku.lineList) {
            ArrayList<Cell> cellList = line.cellList;
            Integer[] cellValue = getAllValueInCell(cellList);
            Arrays.sort(cellValue);
            assertThat(cellValue).isEqualTo(allPossibleNumber);
        }


    }
    @Test
    public void columnShouldHaveEveryNumber(){
        int[][] board = SudokuSolver.easyBoard;
        Sudoku sudoku = new Sudoku(board);
        sudoku.solve();
        Integer[] allPossibleNumber = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (Column column: sudoku.columnsList) {
            ArrayList<Cell> cellList = column.cellList;
            Integer[] cellValue = getAllValueInCell(cellList);
            Arrays.sort(cellValue);
            assertThat(cellValue).isEqualTo(allPossibleNumber);
        }
    }

    @Test
    public void squareShouldHaveEveryNumber(){
        int[][] board = SudokuSolver.easyBoard;
        Sudoku sudoku = new Sudoku(board);
        sudoku.solve();
        Integer[] allPossibleNumber = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (Square square: sudoku.squareList) {
            ArrayList<Cell> cellList = square.cellList;
            Integer[] cellValue = getAllValueInCell(cellList);
            Arrays.sort(cellValue);
            assertThat(cellValue).isEqualTo(allPossibleNumber);
        }
    }


    private Integer[] getAllValueInCell(ArrayList<Cell> cellList){
        Integer[] res = new Integer[9];
        for (int i= 0; i< res.length; i++){
            res[i] = cellList.get(i).value;
        }
        return res;
    }

}

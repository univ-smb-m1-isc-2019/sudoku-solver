package baptistediot;

import baptistediot.board.Cell;
import baptistediot.board.Column;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class SudokuTest {

    @Test
    public void columnShouldHaveEveryNumberFromOneToNineOnce() {
        int[][] board = App.board;
        Sudoku sudoku = new Sudoku(board);

        sudoku.solve();

        Integer[] solution = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        for(int column = 0; column < Sudoku.COLUMN_SIZE; column++){
            Column c = sudoku.getBoard().getColumns(column);

            ArrayList<Cell> cells = c.getColumn();

            Integer[] valueCells = getAllValueNineCells(cells);
            Arrays.sort(valueCells);

            assertThat(valueCells).isEqualTo(solution);
        }
    }

    private Integer[] getAllValueNineCells(ArrayList<Cell> cells){
        Integer[] res = new Integer[9];

        for(int i = 0; i < res.length; ++i){
            res[i] = cells.get(i).getValue();
        }

        return res;
    }

    @Test
    public void rowShouldHaveEveryNumberFromOneToNineOnce() {
    }

    @Test
    public void squareShouldHaveEveryNumberFromOneToNineOnce() {
    }


}

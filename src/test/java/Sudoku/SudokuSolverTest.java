package Sudoku;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit test for simple App.
 */
public class SudokuSolverTest{


    /* values expected in a line/column/matrix */
    public static final Integer[] allValidValuesTab = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    /* method to get the present values in our line/column/matrix */
    private Integer[] getActualValue(ArrayList<Cell> cells){
        Integer[] res = new Integer[9];

        for(int i = 0; i < res.length; ++i){
            res[i] = cells.get(i).getValue();
        }

        return res;
    }

    @Test
    public void validColumn() {
        int[][] board = Main.board;
        Sudoku sudoku = new Sudoku(board);
        sudoku.solver();

        for(int i = 0; i < 9; i++){
            Column col = sudoku.getBoard().getColumns(i);
            ArrayList<Cell> cells = col.getColumn();
            Integer[] columnValues = getActualValue(cells);
            Arrays.sort(columnValues);

            assertThat(columnValues).isEqualTo(allValidValuesTab);
        }
    }

    @Test
    public void validLine() {
        int[][] board = Main.board;
        Sudoku sudoku = new Sudoku(board);
        sudoku.solver();

        for(int i = 0; i < 9; i++){
            Line line = sudoku.getBoard().getLines(i);
            ArrayList<Cell> cells = line.getLine();
            Integer[] lineValues = getActualValue(cells);
            Arrays.sort(lineValues);

            assertThat(lineValues).isEqualTo(allValidValuesTab);
        }
    }

    @Test
    public void validMatrice() {
        int[][] board = Main.board;
        Sudoku sudoku = new Sudoku(board);
        sudoku.solver();

        for(int i = 0; i < 9; i++){
            Matrice mat = sudoku.getBoard().getMatrix(i);
            ArrayList<Cell> cells = mat.getMatrix();
            Integer[] matValues = getActualValue(cells);
            Arrays.sort(matValues);

            assertThat(matValues).isEqualTo(allValidValuesTab);
        }
    }


}


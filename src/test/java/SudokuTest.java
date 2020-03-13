import me.sudoku.Cell;
import me.sudoku.Solver;
import org.junit.Test;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.*;

public class SudokuTest {
    int[][] board = {
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
    @Test
    public void possibleValues_should_decrease_by_line(){
        Solver solver = new Solver(board);
        Cell c = new Cell(board[0][1], 0, 1);
        Cell c1 = new Cell(board[2][0], 2, 0);
        for (int i = 0; i<100; i++){
            solver.reduceFromLine(c);
            assertFalse(c.getPossibleValues().contains(8));
            solver.reduceFromLine(c1);
            assertFalse(c1.getPossibleValues().contains(7));
            assertFalse(c1.getPossibleValues().contains(9));
            assertFalse(c1.getPossibleValues().contains(2));
        }
    }
    @Test
    public void possibleValues_should_decrease_by_col(){
        Solver solver = new Solver(board);
        Cell c = new Cell(board[0][1], 0, 1);
        Cell c1 = new Cell(board[2][0], 2, 0);
        for (int i = 0; i<100; i++){
            solver.reduceFromCol(c);
            assertFalse(c.getPossibleValues().contains(7));
            assertFalse(c.getPossibleValues().contains(5));
            assertFalse(c.getPossibleValues().contains(9));
            solver.reduceFromCol(c1);
            assertFalse(c1.getPossibleValues().contains(8));
        }
    }
}

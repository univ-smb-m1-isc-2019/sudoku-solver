import me.sudoku.Cell;
import me.sudoku.Solver;
import org.junit.Test;

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
    public void cells_resolved_should_not_be_unresolved(){
        Solver solver = new Solver(board);
        solver.solve();
        for (int i = 0; i<board.length; i++){
            for (int j = 0; j<board.length; j++){
            }
        }
    }
}

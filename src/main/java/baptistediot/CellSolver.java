package baptistediot;

import baptistediot.board.*;

import java.util.Arrays;
import java.util.stream.Stream;

public class CellSolver {

    public static Integer[] getPossibilities(Board board, int row, int column){
        CellGroup r = board.getRow(row);
        CellGroup c = board.getColumn(column);
        CellGroup s = board.getSquare(row, column);

        Integer[] rowPossibilities = r.getPossibilities();
        Integer[] columnPossibilities = c.getPossibilities();
        Integer[] squarePossibilities = s.getPossibilities();

        return intersection(rowPossibilities, intersection(columnPossibilities, squarePossibilities));
    }

    public static Integer[] intersection(Integer[] a, Integer[] b){
        return Stream.of(a)
                .filter(Arrays.asList(b)::contains)
                .toArray(Integer[]::new);
    }
}

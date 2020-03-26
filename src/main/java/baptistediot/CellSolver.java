package baptistediot;

import baptistediot.board.Board;
import baptistediot.board.Column;
import baptistediot.board.Row;
import baptistediot.board.Square;

import java.util.Arrays;
import java.util.stream.Stream;

public class CellSolver {

    public static Integer[] getPossibilities(Board board, int row, int column){
        Row r = board.getRows(row);
        Column c = board.getColumns(column);
        Square s = board.getSquares(row, column);

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

package baptistediot.board;

import java.util.ArrayList;

public class Row {
    public ArrayList<Cell> row;

    public Row() {
        this.row = new ArrayList<>();
    }

    public void add(Cell cell) {
        row.add(cell);
    }
}
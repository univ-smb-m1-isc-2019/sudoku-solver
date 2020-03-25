package baptistediot.board;

import java.util.ArrayList;

public class Column {
    public ArrayList<Cell> column;
    public ArrayList<Integer> possibilities;

    public Column() {
        this.column = new ArrayList<>();
        initPossibilities();
    }

    public void add(Cell cell) {
        column.add(cell);
        possibilities.remove(Integer.valueOf(cell.getValue()));
    }

    private void initPossibilities(){
        this.possibilities = new ArrayList<>();

        this.possibilities.add(1);
        this.possibilities.add(2);
        this.possibilities.add(3);
        this.possibilities.add(4);
        this.possibilities.add(5);
        this.possibilities.add(6);
        this.possibilities.add(7);
        this.possibilities.add(8);
        this.possibilities.add(9);
    }
}

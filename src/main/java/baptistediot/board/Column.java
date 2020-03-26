package baptistediot.board;

import java.util.ArrayList;

public class Column {
    private ArrayList<Cell> column;

    public Column() {
        this.column = new ArrayList<>();
    }

    public void add(Cell cell) {
        column.add(cell);
    }

    public ArrayList<Integer> getPossibilities(){
        ArrayList<Integer> possibilities = initPossibilities();

        for(Cell cell: column){
            possibilities.remove(Integer.valueOf(cell.getValue()));
        }

        return possibilities;
    }

    private ArrayList<Integer> initPossibilities(){
        ArrayList<Integer> possibilities = new ArrayList<>();

        possibilities.add(1);
        possibilities.add(2);
        possibilities.add(3);
        possibilities.add(4);
        possibilities.add(5);
        possibilities.add(6);
        possibilities.add(7);
        possibilities.add(8);
        possibilities.add(9);

        return possibilities;
    }
}

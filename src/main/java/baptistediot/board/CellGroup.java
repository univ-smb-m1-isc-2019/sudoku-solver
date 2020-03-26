package baptistediot.board;

import java.util.ArrayList;

public class CellGroup {
    private ArrayList<Cell> cellGroup;

    public CellGroup() {
        this.cellGroup = new ArrayList<>();
    }

    public void add(Cell cell) {
        cellGroup.add(cell);
    }

    public Integer[] getPossibilities(){
        ArrayList<Integer> possibilities = initPossibilities();

        for(Cell cell: cellGroup){
            possibilities.remove(Integer.valueOf(cell.getValue()));
        }

        return possibilities.toArray(new Integer[0]);
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

    public ArrayList<Cell> getCellGroup() {
        return cellGroup;
    }
}

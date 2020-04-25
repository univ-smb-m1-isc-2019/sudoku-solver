package Sudoku;

public class Cell {
    public int value;

    public Cell(int value) {
        this.value = value;
    }

    public String toString() {
        return Integer.toString(value);
    }

    public boolean emptyCell(){
        return value == 0;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

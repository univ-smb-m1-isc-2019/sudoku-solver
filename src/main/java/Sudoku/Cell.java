package Sudoku;

public class Cell {
    public int value;
    /*    CONSTRUCTOR */
    public Cell(int value) {
        this.value = value;
    }

    public String toString() {
        return Integer.toString(value);
    }

    /* cell is empty when it's value is 0 */
    public boolean emptyCell(){
        return value == 0;
    }

    /*  GETTER & SETTER   */
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

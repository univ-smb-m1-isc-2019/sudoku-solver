package fr.lesageolivier;

public class Cell {
    public static final int EMPTY = 0;

    private int value;

    public Cell(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Boolean isEmpty() {
        return this.value == EMPTY;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cell) {
            Cell other = (Cell) obj;

            return this.value == other.value;
        } else {
            return false;
        }
    }
}

package fr.lesageolivier;

public class Cell {
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

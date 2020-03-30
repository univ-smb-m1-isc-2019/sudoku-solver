package com.usmbthomas.sudokuBoard;

public class Cell {
    private int number = 0;

    public Cell(int number) {
        this.number = number;
    }

    public Cell() {
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "[" + number + ']';
    }

}



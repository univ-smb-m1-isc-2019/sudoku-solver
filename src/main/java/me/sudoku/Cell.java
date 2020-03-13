package me.sudoku;

public class Cell {
    private boolean resolved;
    private int value;

    public Cell(int value){
        this.value = value;
        resolved = value != 0;
    }
}

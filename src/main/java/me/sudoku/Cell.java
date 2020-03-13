package me.sudoku;

import java.util.ArrayList;

public class Cell {
    private boolean resolved;
    private int value;
    private int line;
    private int col;
    private ArrayList<Integer> possibleValues = new ArrayList<>();
    public Cell(int value, int line, int col){
        this.value = value;
        for (int i = 1; i < 10; i++) {
            possibleValues.add(i);
        }
        this.line = line;
        this.col = col;
        resolved = value != 0;
    }
    public int getValue(){
        return value;
    }

    public ArrayList<Integer> getPossibleValues() {
        return possibleValues;
    }
    public void removePossibleValue(int v){
        possibleValues.remove(Integer.valueOf(v));
    }
    public int getCol() {
        return col;
    }

    public int getLine() {
        return line;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void resolved() {
        resolved = true;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

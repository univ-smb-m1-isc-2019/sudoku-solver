package fr.jugand.theo.sudoku;

public class Case {
    private int value;

    public Case(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public boolean isEmpty(){
        return this.value == 0;
    }
}

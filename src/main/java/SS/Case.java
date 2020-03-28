package main.java.SS;

public class Case {
    public int value;
    public int x;
    public int y;
    public AvailablePossibilities availablePossibilities;
    public Case(int value){
        this.value = value;
    }
    public Case(int value, int x, int y){
        this.value = value;
        this.x = x;
        this.y = y;
    }
    public int getLineID(){
        return this.y;
    }
    public int getColumnID(){
        return this.x;
    }
    public int getSquareID(){
        return (this.y/3)*3+(this.x/3);
    }
    public void printCase(){
        System.out.println("value = "+this.value);
        System.out.println("x = "+this.x);
        System.out.println("y = "+this.y);
        System.out.println("column = "+this.getColumnID());
        System.out.println("line = "+this.getLineID());
        System.out.println("square = "+this.getSquareID());
    }

}

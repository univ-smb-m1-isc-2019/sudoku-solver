package main.java.SS;

public class Case {
    public int value;
    public Line line;
    public Column column;
    public Square square;
    public int x;
    public int y;
    public Case(int value){
        this.value = value;
    }
    public Case(int value, int x, int y){
        this.value = value;
        this.x = x;
        this.y = y;
    }
    public void addLine(Line line){
        this.line = line;
    }
    public void addColumn(Column column){
        this.column = column;
    }
}

package pack;

//This class represent a single cell.
public class Cell {
    //The value contained into the cell.
    private int value;

    public Cell(int value){
        this.value = value;
    }

    //An empty cell contains 0, return the comparison of 0 with the cell content
    public boolean isEmpty(){
        return value == 0;
    }

    //Getters and setters
    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    //ToString method, to get a simple display
    public String toString(){
        return String.valueOf(value);
    }

}

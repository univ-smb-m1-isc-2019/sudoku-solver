package pack;

public class Cell {

    private int value;

    public Cell(int value){
        this.value = value;
    }

    //An empty cell contains 0, return the comparaison of 0 with the cell content
    public boolean isEmpty(){
        return value == 0;
    }

    public String toString(){
        return String.valueOf(value);
    }


    //Getters and setters
    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

}

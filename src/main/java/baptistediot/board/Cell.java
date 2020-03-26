package baptistediot.board;

public class Cell {
    private int value;

    public Cell(int value){
        this.value = value;
    }

    public boolean isEmpty(){
        return value == 0;
    }

    public String toString(){
        return String.valueOf(value);
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }


}

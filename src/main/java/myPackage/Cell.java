package myPackage;

public class Cell {
    private int value;
    private boolean editable = false;

    public Cell(int value){
        this.value = value;
        if(value == 0)
            this.editable = true;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isEditable() {
        return editable;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "value= " + value +
                ", editable= " + editable +
                '}';
    }
}

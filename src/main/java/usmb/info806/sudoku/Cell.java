package usmb.info806.sudoku;

public class Cell {
    public int id;
    public int value;
    public int x;
    public int y;
    public Possibility possibility;

    public Cell(int value, int x, int y){
        this.value = value;
        this.x = x;
        this.y = y;
    }


    public int getSquareID(){
        return  (x/3 *3) + (y/3);
    }





}

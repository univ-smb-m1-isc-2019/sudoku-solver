package baptistediot.board;

import java.util.ArrayList;

public class Square {
    public ArrayList<Cell> square;

    public Square(){
        this.square = new ArrayList<>();
    }

    public void add(Cell cell){
        square.add(cell);
    }
}

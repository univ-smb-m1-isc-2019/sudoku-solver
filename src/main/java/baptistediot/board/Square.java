package baptistediot.board;

import baptistediot.Sudoku;

public class Square {
    public Cell[] square;

    public Square(){
        this.square = new Cell[Sudoku.SQUARE_SIZE];
    }
}

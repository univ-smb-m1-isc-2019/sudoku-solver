package baptistediot;

public class Row {
    public Cell[] row;

    public Row(){
        this.row = new Cell[Sudoku.ROW_SIZE];
    }
}

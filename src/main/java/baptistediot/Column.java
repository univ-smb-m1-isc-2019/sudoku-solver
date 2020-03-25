package baptistediot;

public class Column {
    public Cell[] column;

    public Column(){
        this.column = new Cell[Sudoku.COLUMN_SIZE];
    }
}

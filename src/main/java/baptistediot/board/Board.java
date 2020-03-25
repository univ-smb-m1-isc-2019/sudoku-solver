package baptistediot.board;

import baptistediot.Sudoku;

public class Board {
    public Cell[][] board;
    public Row[] rows;
    public Column[] columns;
    public Square[] squares;


    public Board(int[][] board) {
        createEmptyRows();
        createEmptyColumns();
        createEmptySquare();

        buildBoard(board);
    }

    private void buildBoard(int[][] board){

    }

    private void createEmptyRows(){
        this.rows = new Row[Sudoku.ROW_SIZE];

        for(int row = 0; row < Sudoku.ROW_SIZE; ++row){
            rows[row] = new Row();
        }
    }

    private void createEmptyColumns(){
        this.columns = new Column[Sudoku.COLUMN_SIZE];

        for(int column = 0; column < Sudoku.COLUMN_SIZE; ++column){
            columns[column] = new Column();
        }
    }

    private void createEmptySquare(){
        this.squares = new Square[Sudoku.SQUARE_SIZE];

        for(int square = 0; square < Sudoku.SQUARE_SIZE; ++square){
            squares[square] = new Square();
        }
    }
}

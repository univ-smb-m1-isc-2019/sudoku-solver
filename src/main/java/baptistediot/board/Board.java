package baptistediot.board;

import baptistediot.Sudoku;

public class Board {
    private Cell[][] board;
    private Row[] rows;
    private Column[] columns;
    private Square[] squares;


    public Board(int[][] board) {
        createEmptyRows();
        createEmptyColumns();
        createEmptySquare();

        buildBoard(board);
    }

    private void buildBoard(int[][] board){
        this.board = new Cell[Sudoku.ROW_SIZE][Sudoku.COLUMN_SIZE];

        for(int row = 0; row < Sudoku.ROW_SIZE; ++row){
            for(int column = 0; column < Sudoku.COLUMN_SIZE; ++column){
                Cell cell = new Cell(board[row][column]);

                this.board[row][column] = cell;

                this.rows[row].add(cell);
                this.columns[column].add(cell);

                int squareNumber = getSquareNumber(row, column);
                this.squares[squareNumber].add(cell);
            }
        }
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

    private int getSquareNumber(int row, int column){
        return (row / 3) * 3 + (column / 3);
    }

    public Column getColumns(int index) {
        return columns[index];
    }

    public Row getRows(int index) {
        return rows[index];
    }

    public Square getSquares(int row, int column) {
        return squares[getSquareNumber(row, column)];
    }

    public Cell getCell(int row, int column){
        return board[row][column];
    }

    public String toString(){
        StringBuilder s = new StringBuilder();

        for(int row = 0; row < Sudoku.ROW_SIZE; ++row) {
            for (int column = 0; column < Sudoku.COLUMN_SIZE; ++column) {
                s.append(board[row][column]);
                s.append("  ");
            }
            s.append("\n");
        }

        return s.toString();
    }
}

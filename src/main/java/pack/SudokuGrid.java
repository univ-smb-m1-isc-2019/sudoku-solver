package pack;

//This class contains all the rows, columns, square, cells that we need to know to solve the Sudoku. And the methods associated
//to initialisations and manipulations of theses data
public class SudokuGrid {
    //All the data about the Sudoku to work on it easily
    private Cell[][] grid;
    private CellGroup[] rows;
    private CellGroup[] columns;
    private CellGroup[] squares;


    public SudokuGrid(int[][] grid) {
        initGrid();
        buildGrid(grid);
    }


    //Initialise an empty grid
    private void initGrid(){
        createEmptyRows();
        createEmptyColumns();
        createEmptySquare();
    }


    //--------------------------------------------------------------------------
    //Methods to initialise our empty grid
    private void createEmptyRows(){
        this.rows = new CellGroup[Sudoku.ROW_SIZE];

        for(int row = 0; row < Sudoku.ROW_SIZE; ++row){
            rows[row] = new CellGroup();
        }
    }

    private void createEmptyColumns(){
        this.columns = new CellGroup[Sudoku.COLUMN_SIZE];

        for(int column = 0; column < Sudoku.COLUMN_SIZE; ++column){
            columns[column] = new CellGroup();
        }
    }

    private void createEmptySquare(){
        this.squares = new CellGroup[Sudoku.SQUARE_SIZE];

        for(int square = 0; square < Sudoku.SQUARE_SIZE; ++square){
            squares[square] = new CellGroup();
        }
    }
    //--------------------------------------------------------------------------


    //The method to build our grid with the real given board
    private void buildGrid(int[][] board){
        this.grid = new Cell[Sudoku.ROW_SIZE][Sudoku.COLUMN_SIZE];

        for(int row = 0; row < Sudoku.ROW_SIZE; ++row){
            for(int column = 0; column < Sudoku.COLUMN_SIZE; ++column){
                Cell cell = new Cell(board[row][column]);

                this.grid[row][column] = cell;

                this.rows[row].add(cell);
                this.columns[column].add(cell);

                int squareNumber = getSquareNumber(row, column);
                this.squares[squareNumber].add(cell);
            }
        }
    }



    //Getters and setters. The returned number ( so the comportment )  or CellGroup depend on what we want to get
    private int getSquareNumber(int row, int column){
        return (row / 3) * 3 + (column / 3);
    }

    public CellGroup getColumn(int index) {
        return columns[index];
    }

    public CellGroup getRow(int index) {
        return rows[index];
    }

    public CellGroup getSquare(int row, int column) {
        return squares[getSquareNumber(row, column)];
    }

    public CellGroup getSquare(int index){
        return squares[index];
    }

    public Cell getCell(int row, int column){
        return grid[row][column];
    }

    //ToString method to get a simple display
    //For each column of each raw, we add the cell value into a var . with spaces and \n . At the end we return that var.
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(int row = 0; row < Sudoku.ROW_SIZE; ++row) {
            for (int column = 0; column < Sudoku.COLUMN_SIZE; ++column) {
                s.append(grid[row][column]);
                s.append("  ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}

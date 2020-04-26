package pack;
//The class permit to solve our Sudoku . It contains the solve method and some global var about our Sudoku.
public class Sudoku {

    //Some global variables about our sudoku
    public static final int ROW_SIZE = 9;
    public static final int COLUMN_SIZE = 9;
    public static final int SQUARE_SIZE = 9;

    private SudokuGrid grid;


    //Our Sudoku constructor
    public Sudoku(int[][] grid){
        this.grid = new SudokuGrid(grid);
    }


    //The method which permit to know of the Sudoku has solution or not
    public boolean solve(){
        //For each column of each row
        for(int row = 0; row < ROW_SIZE; ++row) {
            for (int column = 0; column < COLUMN_SIZE; ++column) {
                //We get the current cell and test if it's empty
                Cell cell = grid.getCell(row, column);

                if(cell.isEmpty()) {
                    //The current cell is empty, we get all the possibilities then
                    Integer[] possibilities = CellSolver.getPossibilities(grid, row, column);

                    //For each possibility given before, we try to solve the Sudoku by supposing that this possibility is the good one
                    //and calling recursively this method with this assumption.
                    for (Integer possibility : possibilities) {
                        cell.setValue(possibility);

                        if (solve()) {
                            return true;
                        }

                        //If this possibility is not the good one, we put 0 into this cell : nothing changed.
                        //Or we will try with an other possibility, if there is some remaining
                        else{
                            cell.setValue(0);
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    public String toString(){
        return grid.toString();
    }

}

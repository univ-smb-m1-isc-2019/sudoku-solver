package Sudoku;

public class Sudoku {
    public static final int SIZE = 9;
    private Grid board;

    /*    CONSTRUCTOR */
    public Sudoku(int[][] board){
        this.board = new Grid(board);
    }

    public String toString(){
        return board.toString();
    }

    /*  GETTER  */
    public Grid getBoard(){
        return board;
    }


    public boolean solver(){
        for(int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                Cell cell = board.getCell(i, j);
                if(cell.emptyCell()) {
                    Integer[] validValues = Solver.getPossibleValues(board, i, j);
                    for (Integer value : validValues) {
                        cell.setValue(value);
                        if (solver()) {
                            return true;
                        }
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
}

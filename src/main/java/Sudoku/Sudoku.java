package Sudoku;

public class Sudoku {
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
        for(int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
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

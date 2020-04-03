package myPackage;

public class ColumnLineOperations {

    /***
     *Test if value present in column of board.
     * @param cellBoard - Board of sudoku.
     * @param column - column for test.
     * @param val - value for test.
     * @return - true when value not present in column.
     */
    public boolean columnTest(Cell[][] cellBoard, int column, int val){
        for (int i = 0; i < cellBoard.length; i++ ){
            if(cellBoard[i][column].getValue()== val)
                return false;
        }
        return true;
    }


    /***
     *Test if value present in line of board.
     * @param cellBoard - Board of sudoku.
     * @param line - line for test.
     * @param val - value for test.
     * @return - true when value not present in line.
     */
    public boolean lineTest(Cell[][] cellBoard, int line ,int val){
        for (int i = 0; i < cellBoard.length; i++ ){
            if(cellBoard[line][i].getValue() == val)
                return false;
        }
        return true;
    }
}

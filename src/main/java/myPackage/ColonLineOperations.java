package myPackage;

public class ColonLineOperations {

    /***
     *Test if value present in colon of board.
     * @param cellBoard - Board of sudoku.
     * @param colon - colon for test.
     * @param val - value for test.
     * @return - true when value not present in colon.
     */
    public boolean colonTest(Cell[][] cellBoard, int colon, int val){
        for (int i = 0; i < cellBoard.length; i++ ){
            if(cellBoard[i][colon].getValue()== val)
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

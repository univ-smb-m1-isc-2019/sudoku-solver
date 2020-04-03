package myPackage;
import java.util.ArrayList;

public class Solver {
    public static final int  VALUE_NOT_OK= 999;
    public static final int  VALUE_OK= 777;
    private Board mySdkBoard;
    private Cell[][] boardSudoku;
    private ArrayList<Square> arrayWithSquares;
    private ColumnLineOperations clOperations;


    public Solver(Board mySdkBoard){
        this.mySdkBoard = mySdkBoard;
        this.boardSudoku = mySdkBoard.getCellBoard();
        this.arrayWithSquares = mySdkBoard.getArrayWithSquares();
        this.clOperations = new ColumnLineOperations();
    }

    /***
     *Method for resolve sudoku board.
     */
    public void sudokuSolve(){
        int indexSquare = 0;
        int line = 0;
        int column = 0;
        boolean findOk;

        while (indexSquare < 9 && indexSquare >= 0){

            findOk = squareSolve(indexSquare, line, column);

            if(findOk){

                indexSquare++;
                if(indexSquare < 9){
                    line = arrayWithSquares.get(indexSquare).line;
                    column = arrayWithSquares.get(indexSquare).column;
                }

            }else{
                indexSquare--;
                if(indexSquare > -1){
                    line = arrayWithSquares.get(indexSquare).lineEnd;
                    column = arrayWithSquares.get(indexSquare).columnEnd;
                }
            }
        }
    }

    /***
     * Method for find all values of square.
     * @param squareIndex - The index of the square that need be solves.
     * @param line - index of actual square line.
     * @param column - index of actual square column.
     * @return - True when square was resolved.
     */
    public boolean squareSolve(int squareIndex, int line, int column){
        Square squareForSolve = arrayWithSquares.get(squareIndex);
        int []dataArray;
        boolean moveBack;

        if(line == VALUE_NOT_OK && column == VALUE_NOT_OK)
            return false;
       else if (line == VALUE_OK && column == VALUE_OK)
            return true;

        else {

            moveBack = !findSetCellValue(line, column, squareForSolve);

            if(moveBack)
                dataArray = jumpBackNotEditableCase(line, column, squareForSolve);
            else
                dataArray = jumpAheadNotEditableCase(line, column, squareForSolve);
        }
        return squareSolve(squareIndex, dataArray[0], dataArray[1]);
    }

    /***
     * Method for incrementing cell's index, while it's not editable.
     * @param line - index of actual cell line.
     * @param column - index of actual cell column.
     * @param squareForSolve - square that need be solve.
     * @return - Array with two values that correspond to index for finding the next cell.
     */
    public int[] jumpAheadNotEditableCase(int line, int column, Square squareForSolve){
        int []dataArray = moveAhead(line, column, squareForSolve);

        if(dataArray[0] != VALUE_OK && dataArray[0] != VALUE_NOT_OK){
            while(!boardSudoku[dataArray[0]][dataArray[1]].isEditable()){
                if(boardSudoku[dataArray[0]][dataArray[1]].getValue() == VALUE_OK)
                    return dataArray;
                dataArray = jumpAheadNotEditableCase(dataArray[0],dataArray[1],squareForSolve);
            }
        }
        return dataArray;
    }

    /***
     * Method for decrementing cell's index, while it's not editable .
     * @param line - index of actual cell line.
     * @param column - index of actual cell column.
     * @param squareForSolve - square that need be solve.
     * @return - Array with two values that correspond to index for finding the previous cell.
     */
    public int[] jumpBackNotEditableCase(int line, int column, Square squareForSolve){
        int []dataArray = moveBackMethod(line, column, squareForSolve);

        if(dataArray[0] != VALUE_NOT_OK && dataArray[1] != VALUE_NOT_OK) {
            while (!boardSudoku[dataArray[0]][dataArray[1]].isEditable()) {
                if (boardSudoku[dataArray[0]][dataArray[1]].getValue() == VALUE_NOT_OK)
                    return dataArray;
                dataArray = jumpBackNotEditableCase(dataArray[0], dataArray[1], squareForSolve);
            }
        }
        return dataArray;
    }

    /***
     * Method for incrementing cell's index for check next one.
     * @param line - index of actual cell line.
     * @param column - index of actual cell column.
     * @param squareForSolve - square that need be solve.
     * @return - Array with two values that correspond to index for finding the next cell.
     */
    public int[] moveAhead(int line, int column, Square squareForSolve){

        if(line != squareForSolve.line + 2 && column == squareForSolve.column + 2 ){
            line++;
            column = squareForSolve.column;
        }

        else if(column < squareForSolve.column + 2){
            column++;
        }

        else if(line == squareForSolve.line + 2 && column == squareForSolve.column + 2){
            line = VALUE_OK;
            column = VALUE_OK;
        }

        return (new int[]{line,column});
    }

    /***
     * Method for decrementing cell's index for check previous one.
     * @param line - index of actual cell line.
     * @param column - index of actual cell column.
     * @param squareForSolve - square that need be solve.
     * @return - Array with two values that correspond to index for finding the previous cell.
     */
    public int[] moveBackMethod(int line, int column, Square squareForSolve){

        mySdkBoard.initCellOfBoard(line,column); // Initialize actual cell's value. (0)

        if(line != squareForSolve.line && column == squareForSolve.column){
            line--;
            column+=2;
        }

        else if(column > squareForSolve.column){
            column--;
        }

        else if(line == squareForSolve.line && column == squareForSolve.column){
            line = VALUE_NOT_OK;
            column = VALUE_NOT_OK;
        }

        return (new int[]{line, column});
    }

    /***
     *Find and set the value of cell if it's possible.
     * @param line - index of cell line.
     * @param column - index of cell column.
     * @param squareForSolve - square that need be solve.
     * @return - true when value was found.
     */
    public boolean findSetCellValue(int line, int column, Square squareForSolve ){
        boolean find = false;

        if(boardSudoku[line][column].isEditable()) {
            int index = getValueForCell(line, column, squareForSolve.getValuesPossibleAll());

            if (index != VALUE_NOT_OK) {

                while (!find && index < squareForSolve.getValuesPossibleAll().size()) {
                    int valueForTest = squareForSolve.getValuesPossibleAll().get(index);
                    if (
                            clOperations.columnTest(boardSudoku, column, valueForTest) &&
                                    clOperations.lineTest(boardSudoku, line, valueForTest) &&
                                    squareForSolve.checkSquare(boardSudoku, squareForSolve, valueForTest)) {
                        boardSudoku[line][column].setValue(valueForTest);
                        find = true;
                    }
                    index++;
                }
            }
        }
        else if (!boardSudoku[line][column].isEditable() && !squareForSolve.testStarted && column == squareForSolve.column && line == squareForSolve.line) {
            squareForSolve.testStarted = true;
            find = true;
        }

        return find;
    }

    /***
     *Get index of actual value of cell.
     * @param line - index of cell line.
     * @param column - index of cell column.
     * @param valuesPossibleActual - array with values that can be possible for cell.
     * @return - index of actual value.
     */
    public int getActualIndexOfValue(int line, int column, ArrayList<Integer> valuesPossibleActual) {
        if (boardSudoku[line][column].getValue() != 0) {
            for (int i = 0; i < valuesPossibleActual.size(); i++) {
                if (valuesPossibleActual.get(i) == boardSudoku[line][column].getValue())
                    return i;
            }
        }
        return 0;
    }

    /***
     *Find the value that can be possible for cell.
     * @param line - index of cell line.
     * @param column - index of cell column.
     * @param valuesPossibleActual - array with values that can be possible for cell.
     * @return - index of value that can be possible for cell.
     */
    public int getValueForCell(int line, int column, ArrayList<Integer> valuesPossibleActual){
        int actualIndexOfValue = getActualIndexOfValue(line, column, valuesPossibleActual);

        for (int i = actualIndexOfValue; i < valuesPossibleActual.size(); i++) {
            if(valuesPossibleActual.get(i) > boardSudoku[line][column].getValue())
                return i;
        }

       if(actualIndexOfValue + 1  == valuesPossibleActual.size())
            return VALUE_NOT_OK;

        return 0;
    }

}

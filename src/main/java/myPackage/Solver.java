package myPackage;
import java.util.ArrayList;

public class Solver {
    public static final int  VALUE_NOT_OK= 999;
    public static final int  VALUE_OK= 777;
    private Board mySdkBoard;
    private Cell[][] boardSudoku;
    private ArrayList<Square> arrayWithSquares;
    private ColonLineOperations clOperations;


    public Solver(Board mySdkBoard){
        this.mySdkBoard = mySdkBoard;
        this.boardSudoku = mySdkBoard.getCellBoard();
        this.arrayWithSquares = mySdkBoard.getArrayWithSquares();
        this.clOperations = new ColonLineOperations();
    }

    /***
     *Method for resolve sudoku board.
     */
    public void sudokuSolve(){
        int indexSquare = 0;
        int line = 0;
        int colon = 0;
        boolean findOk;

        while (indexSquare < 9 && indexSquare >= 0){

            findOk = squareSolve(indexSquare, line, colon);

            if(findOk){

                indexSquare++;
                if(indexSquare < 9){
                    line = arrayWithSquares.get(indexSquare).line;
                    colon = arrayWithSquares.get(indexSquare).colon;
                }

            }else{
                indexSquare--;
                if(indexSquare > -1){
                    line = arrayWithSquares.get(indexSquare).lineEnd;
                    colon = arrayWithSquares.get(indexSquare).colonEnd;
                }
            }
        }
    }

    /***
     * Method for find all values of square.
     * @param squareIndex - The index of the square that need be solves.
     * @param line - index of actual square line.
     * @param colon - index of actual square colon.
     * @return - True when square was resolved.
     */
    public boolean squareSolve(int squareIndex, int line, int colon){
        Square squareForSolve = arrayWithSquares.get(squareIndex);
        int []dataArray;
        boolean moveBack;

        if(line == VALUE_NOT_OK && colon == VALUE_NOT_OK)
            return false;
       else if (line == VALUE_OK && colon == VALUE_OK)
            return true;

        else {

            moveBack = !findSetCellValue(line, colon, squareForSolve);

            if(moveBack)
                dataArray = jumpBackNotEditableCase(line, colon, squareForSolve);
            else
                dataArray = jumpAheadNotEditableCase(line, colon, squareForSolve);
        }
        return squareSolve(squareIndex, dataArray[0], dataArray[1]);
    }

    /***
     * Method for incrementing cell's index, while it's not editable.
     * @param line - index of actual cell line.
     * @param colon - index of actual cell colon.
     * @param squareForSolve - square that need be solve.
     * @return - Array with two values that correspond to index for finding the next cell.
     */
    public int[] jumpAheadNotEditableCase(int line, int colon, Square squareForSolve){
        int []dataArray = moveAhead(line, colon, squareForSolve);

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
     * @param colon - index of actual cell colon.
     * @param squareForSolve - square that need be solve.
     * @return - Array with two values that correspond to index for finding the previous cell.
     */
    public int[] jumpBackNotEditableCase(int line, int colon, Square squareForSolve){
        int []dataArray = moveBackMethod(line, colon, squareForSolve);

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
     * @param colon - index of actual cell colon.
     * @param squareForSolve - square that need be solve.
     * @return - Array with two values that correspond to index for finding the next cell.
     */
    public int[] moveAhead(int line, int colon, Square squareForSolve){

        if(line != squareForSolve.line + 2 && colon == squareForSolve.colon + 2 ){
            line++;
            colon = squareForSolve.colon;
        }

        else if(colon < squareForSolve.colon + 2){
            colon++;
        }

        else if(line == squareForSolve.line + 2 && colon == squareForSolve.colon + 2){
            line = VALUE_OK;
            colon = VALUE_OK;
        }

        return (new int[]{line,colon});
    }

    /***
     * Method for decrementing cell's index for check previous one.
     * @param line - index of actual cell line.
     * @param colon - index of actual cell colon.
     * @param squareForSolve - square that need be solve.
     * @return - Array with two values that correspond to index for finding the previous cell.
     */
    public int[] moveBackMethod(int line, int colon, Square squareForSolve){

        mySdkBoard.initCellOfBoard(line,colon); // Initialize actual cell's value. (0)

        if(line != squareForSolve.line && colon == squareForSolve.colon){
            line--;
            colon+=2;
        }

        else if(colon > squareForSolve.colon){
            colon--;
        }

        else if(line == squareForSolve.line && colon == squareForSolve.colon){
            line = VALUE_NOT_OK;
            colon = VALUE_NOT_OK;
        }

        return (new int[]{line, colon});
    }

    /***
     *Find and set the value of cell if it's possible.
     * @param line - index of cell line.
     * @param colon - index of cell colon.
     * @param squareForSolve - square that need be solve.
     * @return - true when value was found.
     */
    public boolean findSetCellValue(int line, int colon, Square squareForSolve ){
        boolean find = false;

        if(boardSudoku[line][colon].isEditable()) {
            int index = getValueForCell(line, colon, squareForSolve.getValuesPossibleAll());

            if (index != VALUE_NOT_OK) {

                while (!find && index < squareForSolve.getValuesPossibleAll().size()) {
                    int valueForTest = squareForSolve.getValuesPossibleAll().get(index);
                    if (
                            clOperations.colonTest(boardSudoku, colon, valueForTest) &&
                                    clOperations.lineTest(boardSudoku, line, valueForTest) &&
                                    squareForSolve.checkSquare(boardSudoku, squareForSolve, valueForTest)) {
                        boardSudoku[line][colon].setValue(valueForTest);
                        find = true;
                    }
                    index++;
                }
            }
        }
        else if (!boardSudoku[line][colon].isEditable() && !squareForSolve.testStarted && colon == squareForSolve.colon && line == squareForSolve.line) {
            squareForSolve.testStarted = true;
            find = true;
        }

        return find;
    }

    /***
     *Get index of actual value of cell.
     * @param line - index of cell line.
     * @param colon - index of cell colon.
     * @param valuesPossibleActual - array with values that can be possible for cell.
     * @return - index of actual value.
     */
    public int getActualIndexOfValue(int line, int colon, ArrayList<Integer> valuesPossibleActual) {
        if (boardSudoku[line][colon].getValue() != 0) {
            for (int i = 0; i < valuesPossibleActual.size(); i++) {
                if (valuesPossibleActual.get(i) == boardSudoku[line][colon].getValue())
                    return i;
            }
            //return VALUE_NOT_OK;
        }
        return 0;
    }

    /***
     *Find the value that can be possible for cell.
     * @param line - index of cell line.
     * @param colon - index of cell colon.
     * @param valuesPossibleActual - array with values that can be possible for cell.
     * @return - index of value that can be possible for cell.
     */
    public int getValueForCell(int line, int colon, ArrayList<Integer> valuesPossibleActual){
        int actualIndexOfValue = getActualIndexOfValue(line, colon, valuesPossibleActual);

        for (int i = actualIndexOfValue; i < valuesPossibleActual.size(); i++) {
            if(valuesPossibleActual.get(i) > boardSudoku[line][colon].getValue())
                return i;
        }

       if(actualIndexOfValue + 1  == valuesPossibleActual.size())
            return VALUE_NOT_OK;

        return 0;
    }

}

package myPackage;

import javafx.scene.control.skin.CellSkinBase;

import java.util.ArrayList;
import java.util.function.Function;

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
        this.arrayWithSquares = new ArrayList<>();
        this.clOperations = new ColonLineOperations();
    }

    public void testSolve(){
        squareSolve(0, 0, 0);
        mySdkBoard.displayBoard();
        /*squareSolve(1, 0, 3);
        mySdkBoard.displayBoard();*/

    }

    public void createArrayWithSquares(){
        for(int line = 0 ; line < boardSudoku.length; line+=3 ){
            for(int colon = 0; colon < boardSudoku.length; colon+=3){
                Square newSquare = new Square(line,colon);
                newSquare.createSquareValuePossible(boardSudoku);
                arrayWithSquares.add(newSquare);
            }
        }
    }

    public void displayArrayWithSquares(){
        for (Square item : arrayWithSquares) {
            System.out.println(item.toString());
        }
    }

    public boolean squareSolve(int squareIndex, int line, int colon){
        Square squareForSolve = arrayWithSquares.get(squareIndex);
        int dataArray[];
        boolean moveBack;

        if(line == VALUE_NOT_OK && colon == VALUE_NOT_OK)
            return false;
        else{
            if(line == VALUE_OK && colon == VALUE_OK)
                return true;

            moveBack = !findSetCellValue(line, colon, squareForSolve);

            if(moveBack)
                dataArray = jumpBackNotEditableCase(line, colon, squareForSolve);
            else
                dataArray = jumpAheadNotEditableCase(line, colon, squareForSolve);

            squareSolve(squareIndex, dataArray[0], dataArray[1]);


        }
        return false;
    }

    public int[] jumpAheadNotEditableCase(int line, int colon, Square squareForSolve){
        int dataArray[] = moveAhead(line, colon, squareForSolve);

        if(dataArray[0] != VALUE_OK && dataArray[0] != VALUE_NOT_OK){
            while(!boardSudoku[dataArray[0]][dataArray[1]].isEditable()){
                if(boardSudoku[dataArray[0]][dataArray[1]].getValue() == VALUE_OK)
                    return dataArray;
                dataArray = jumpAheadNotEditableCase(dataArray[0],dataArray[1],squareForSolve);
            }
        }
        return dataArray;
    }

    public int[] jumpBackNotEditableCase(int line, int colon, Square squareForSolve){
        int dataArray[] = moveBackMethod(line, colon, squareForSolve);

        if(dataArray[0] != VALUE_NOT_OK && dataArray[0] != VALUE_NOT_OK) {
            while (!boardSudoku[dataArray[0]][dataArray[1]].isEditable()) {
                if (boardSudoku[dataArray[0]][dataArray[1]].getValue() == VALUE_NOT_OK)
                    return dataArray;
                dataArray = jumpBackNotEditableCase(dataArray[0], dataArray[1], squareForSolve);
            }
        }
        return dataArray;
    }

    public int[] moveAhead(int line, int colon, Square squareForSolve){
        int []dataArray = new int[2];

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

        dataArray[0] = line;
        dataArray[1] = colon;

        return dataArray;
    }

    public int[] moveBackMethod(int line, int colon, Square squareForSolve){
        int []dataArray = new int[2];

        mySdkBoard.initCellOfBoard(line,colon);

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

        dataArray[0] = line;
        dataArray[1] = colon;



        return dataArray;
    }

    public boolean findSetCellValue(int line, int colon, Square squareForSolve ){
        boolean find = false;

        if(boardSudoku[line][colon].isEditable()){
            int index = getValueForCell(line, colon,squareForSolve.getValuesPossibleAll());

            while (!find && index < squareForSolve.getValuesPossibleAll().size()){
                int valueForTest = squareForSolve.getValuesPossibleAll().get(index);
                if(
                        clOperations.colonTest(boardSudoku, colon,valueForTest ) &&
                        clOperations.lineTest(boardSudoku, line, valueForTest) &&
                        squareForSolve.checkSquare(boardSudoku,squareForSolve, valueForTest))
                {
                    boardSudoku[line][colon].setValue(valueForTest);
                    find = true;
                }
                index++;
            }

        }else if(!boardSudoku[line][colon].isEditable() && !squareForSolve.testStarted  && colon == squareForSolve.colon && line == squareForSolve.line){
            squareForSolve.testStarted = true;
            find = true;
        }
        return find;
    }

    public int getActualIndexOfValue(int line, int colon, ArrayList<Integer> valuesPossibleActual) {
        if (boardSudoku[line][colon].getValue() != 0) {
            for (int i = 0; i < valuesPossibleActual.size(); i++) {
                if (valuesPossibleActual.get(i) == boardSudoku[line][colon].getValue())
                    return i;
            }
            return VALUE_NOT_OK;
        }
        return 0;
    }

    public int getValueForCell(int line, int colon, ArrayList<Integer> valuesPossibleActual){
        int actualIndexOfValue = getActualIndexOfValue(line, colon, valuesPossibleActual);
        for (int i  = actualIndexOfValue; i < valuesPossibleActual.size(); i++) {
            if(valuesPossibleActual.get(i) > boardSudoku[line][colon].getValue())
                return i;
        }
        return 0;
    }

}

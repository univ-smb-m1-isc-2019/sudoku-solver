package myPackage;

import java.util.ArrayList;

public class Solver {
    public static final int  VALUE_NOT_OK= 999;
    private Cell[][] boardSudoku;
    private ArrayList<Square> arrayWithSquares;
    private ColonLineOperations clOperations;

    public Solver(Cell[][]  boardSudoku){
        this.boardSudoku = boardSudoku;
        this.arrayWithSquares = new ArrayList<>();
        this.clOperations = new ColonLineOperations();
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

    private void solver(){}

    /*        for (int i = squareForSolve.colon; i < squareForSolve.colon+3; i++){
            for (int j = squareForSolve.line; j < squareForSolve.line+3; j++){*/

    private boolean squareSolve(int squareIndex, int i, int j){
        Square squareForSolve = arrayWithSquares.get(squareIndex);
        boolean moveBack = false;
        if(boardSudoku[i][j].isEditable()){
            moveBack = !findSetCellValue(i,j,squareForSolve);
        }
        if(moveBack){
            squareSolve(squareIndex,i+1,j+1);
        }else {
            squareSolve(squareIndex,i+1,j+1);
        }
        return false;
    }

    public int[] moveBackMethod(int colon, int line, Square squareForSolve){
        int []dataArray = new int[2];

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

        dataArray[0] = colon;
        dataArray[1] = line;

        return dataArray;


    }

    public boolean findSetCellValue(int colon, int line, Square squareForSolve ){
        boolean find = false;

        if(boardSudoku[colon][line].isEditable()){
            int index = getValueForCell(colon,line,squareForSolve.getValuesPossibleActual());

            while (!find && index < squareForSolve.getValuesPossibleActual().size()){
                int valueForTest = squareForSolve.getValuesPossibleActual().get(index);
                if(clOperations.colonTest(boardSudoku, colon, line,valueForTest ) && clOperations.lineTest(boardSudoku, colon, line, valueForTest)) {
                    boardSudoku[colon][line].setValue(valueForTest);
                    squareForSolve.updateSquareValue(squareForSolve.getValuesPossibleActual(),valueForTest);
                    find = true;
                }
                index++;
            }
        }
        return find;
    }

    public int getActualIndexOfValue(int colon, int line, ArrayList<Integer> valuesPossibleActual) {
        if (boardSudoku[colon][line].getValue() != 0) {
            for (int i = 0; i < valuesPossibleActual.size(); i++) {
                if (valuesPossibleActual.get(i) == boardSudoku[colon][line].getValue())
                    return i;
            }
            return VALUE_NOT_OK;
        }
        return 0;
    }

    public int getValueForCell(int colon, int line, ArrayList<Integer> valuesPossibleActual){
        int actualIndexOfValue = getActualIndexOfValue(colon, line, valuesPossibleActual);
        for (int i = actualIndexOfValue; i < valuesPossibleActual.size(); i++) {
            if(valuesPossibleActual.get(i) > boardSudoku[colon][line].getValue())
                return i;
        }
        return VALUE_NOT_OK;
    }

}

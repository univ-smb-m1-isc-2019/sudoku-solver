package myPackage;

import java.util.ArrayList;

public class Square {
    private ArrayList<Integer> valuesPossibleAll;

    public int line;
    public int colon;
    public int lineEnd;
    public int colonEnd;
    public boolean testStarted;

    public Square(int line, int colon){
        this.line = line;
        this.colon = colon;
        this.lineEnd = line + 2;
        this.colonEnd = colon + 2;
        this.testStarted = false;
        initTabTestTemp();
    }

    public ArrayList<Integer> getValuesPossibleAll() {
        return valuesPossibleAll;
    }

    /***
     * Initialization of array with values possible for square.
     */
    private void initTabTestTemp(){
        this.valuesPossibleAll = new ArrayList<>();
        for(int i = 1; i < 10; i++)
            this.valuesPossibleAll.add(i);
    }

    /***
     * Delete the value from array with values possible if it's present in square.
     * @param values - Array with values that need be possible for square.
     * @param valOfCell - Value for delete from array with values possible.
     */
    public void updateSquareValue (ArrayList<Integer> values, int valOfCell){
        int i = 0;
        while (i < values.size() && values.get(i) != valOfCell)
            i++;

        if (i < values.size() && values.get(i) == valOfCell)
            values.remove(i);
    }

    /***
     * Generation of array with values possible for square.
     * @param cellBoard - cellBoard - Board of sudoku.
     */
    public void createSquareValuePossible(Cell[][] cellBoard){
        for(int i = line ; i < line + 3; i++ ){
            for(int j = colon; j < colon + 3; j++){
                int valOFCell = cellBoard[i][j].getValue();
                updateSquareValue(valuesPossibleAll, valOFCell);
            }
        }
    }

    /***
     * Test if value present in square.
     * @param cellBoard - Board of sudoku.
     * @param squareForTest - Square for check.
     * @param val - value for test.
     * @return true when value not present in square.
     */
    public boolean checkSquare(Cell[][] cellBoard, Square squareForTest, int val){
        for(int i = squareForTest.line ; i < line + 3; i++ ){
            for(int j = squareForTest.colon; j < colon + 3; j++){
                if(cellBoard[i][j].getValue() == val)
                    return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nSquare{" +
                "\nvaluesPossibleAll= " + valuesPossibleAll +
                ",\nline= " + line +
                ",\ncolon= " + colon +
                "\n";
    }
}

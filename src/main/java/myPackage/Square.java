package myPackage;

import java.util.ArrayList;

public class Square {
    private ArrayList<Integer> valuesPossibleAll;
    private ArrayList<Integer> valuesPossibleActual;

    public int line;
    public int colon;

    public Square(){
        initTabTestTemp();
    }

    public Square(int line, int colon){
        this.line = line;
        this.colon = colon;
        initTabTestTemp();
    }

    public ArrayList<Integer> getValuesPossibleAll() {
        return valuesPossibleAll;
    }

    public ArrayList<Integer> getValuesPossibleActual() {
        return valuesPossibleActual;
    }

    private void initTabTestTemp(){
        this.valuesPossibleAll = new ArrayList<>();
        for(int i = 1; i < 10; i++)
            this.valuesPossibleAll.add(i);
    }

    public void updateSquareValue (ArrayList<Integer> values, int valOfCell){
        int i = 0;
        while (i < values.size() && values.get(i) != valOfCell)
            i++;

        if (i < values.size() && values.get(i) == valOfCell)
            values.remove(i);
    }

    public void createSquareValuePossible(Cell[][] cellBoard){
        for(int i = line ; i < line + 3; i++ ){
            for(int j = colon; j < colon + 3; j++){
                int valOFCell = cellBoard[i][j].getValue();
                updateSquareValue(valuesPossibleAll, valOFCell);
            }
        }
        valuesPossibleActual = valuesPossibleAll;
    }


    @Override
    public String toString() {
        return "\nSquare{" +
                "\nvaluesPossibleAll= " + valuesPossibleAll +
                ",\nvaluesPossibleActual= " + valuesPossibleActual +
                ",\nline= " + line +
                ",\ncolon= " + colon +
                "\n";
    }
}

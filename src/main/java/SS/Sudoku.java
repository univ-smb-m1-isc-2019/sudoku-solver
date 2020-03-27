package main.java.SS;

import java.util.ArrayList;
import java.util.Arrays;

public class Sudoku {
    public ArrayList<Line> lineList;
    public ArrayList<Column> columnList;
    public ArrayList<Square> squaresList;
    public Sudoku(int[][] board){
        //initialisation
        this.lineList = new ArrayList<Line>();
        //chargement line
        Arrays.stream(board).forEach(i -> {

        });
        //chargement column
    }
    public void addLine(Line line){
        this.lineList.add(line);
    }
    public void addColumn(Column column){
        this.columnList.add(column);
    }
    public void addSquare(Square square){
        this.squaresList.add(square);
    }
}

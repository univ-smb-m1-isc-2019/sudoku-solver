package myPackage;

import java.util.ArrayList;

public class Board {

    private ArrayList<Square> arrayWithSquares;
    private Cell[][] cellBoard;
    
    public Board(){
        this.cellBoard = new Cell[9][9];
        this.arrayWithSquares = new ArrayList<>();
    }

    public ArrayList<Square> getArrayWithSquares() {
        return arrayWithSquares;
    }

    public Cell[][] getCellBoard() {
        return cellBoard;
    }

    public void setCellOfBoard(int line, int column, int val){
        cellBoard[line][column] = new Cell(val);
    }

    public void initCellOfBoard(int line,int column){
        if(cellBoard[line][column].isEditable())
            cellBoard[line][column].setValue(0);
    }

    public void createBoard(int[][] boardSudoku){

        for(int line = 0; line < boardSudoku.length; line++){
            for (int column = 0; column < boardSudoku.length; column++){
                int valOfboardSudoku = boardSudoku[line][column];
                setCellOfBoard(line, column, valOfboardSudoku);
            }
        }
    }

    public void createArrayWithSquares(){
        for(int line = 0 ; line < cellBoard.length; line+=3 ){
            for(int column = 0; column < cellBoard.length; column+=3){
                Square newSquare = new Square(line,column);
                newSquare.createSquareValuePossible(cellBoard);
                arrayWithSquares.add(newSquare);
            }
        }
    }

    public void displayArrayWithSquares(){
        for (Square item : arrayWithSquares) {
            System.out.println(item.toString());
        }
    }

    public void displayBoard() {
        System.out.println("========= Board =========");
        for(int line = 0; line < cellBoard.length; line++){
            System.out.print("| ");
            for (int column = 0; column < cellBoard.length; column++){
                System.out.print(cellBoard[line][column].getValue() + " ");
                if((column+1) % 3 == 0 && (column+1) != 9)
                    System.out.print("| ");
            }
            System.out.print("|" +"\n");

            if((line+1) % 3 == 0 && (line+1) != 9)
                System.out.println("-------------------------");
        }
        System.out.println("=========================");
    }
}

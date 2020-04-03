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

    public void setCellOfBoard(int line, int colon, int val){
        cellBoard[line][colon] = new Cell(val);
    }

    public void initCellOfBoard(int line,int colon){
        if(cellBoard[line][colon].isEditable())
            cellBoard[line][colon].setValue(0);
    }

    public void createBoard(int[][] boardSudoku){

        for(int line = 0; line < boardSudoku.length; line++){
            for (int colon = 0; colon < boardSudoku.length; colon++){
                int valOfboardSudoku = boardSudoku[line][colon];
                setCellOfBoard(line, colon, valOfboardSudoku);
            }
        }
    }

    public void createArrayWithSquares(){
        for(int line = 0 ; line < cellBoard.length; line+=3 ){
            for(int colon = 0; colon < cellBoard.length; colon+=3){
                Square newSquare = new Square(line,colon);
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
            for (int colon = 0; colon < cellBoard.length; colon++){
                System.out.print(cellBoard[line][colon].getValue() + " ");
                if((colon+1) % 3 == 0 && (colon+1) != 9)
                    System.out.print("| ");
            }
            System.out.print("|" +"\n");

            if((line+1) % 3 == 0 && (line+1) != 9)
                System.out.println("-------------------------");
        }
        System.out.println("=========================");
    }
}

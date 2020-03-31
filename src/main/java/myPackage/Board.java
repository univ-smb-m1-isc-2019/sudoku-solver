package myPackage;

import java.util.Arrays;

public class Board {

    private Cell[][] cellBoard;
    
    
    public Board(){
        this.cellBoard = new Cell[9][9];
    }


    public Cell[][] getCellBoard() {
        return cellBoard;
    }

    public void setCellOfBoard(int line, int colon, int val){
        cellBoard[line][colon] = new Cell(val);
    }

    public void createBoard(int[][] boardSudoku){

        for(int line = 0; line < boardSudoku.length; line++){
            for (int colon = 0; colon < boardSudoku.length; colon++){
                int valOfboardSudoku = boardSudoku[line][colon];
                setCellOfBoard(line, colon, valOfboardSudoku);
            }
        }
    }


    public void displayBoard() {
        for(int line = 0; line < cellBoard.length; line++){
            System.out.print("| ");
            for (int colon = 0; colon < cellBoard.length; colon++){
                System.out.print(cellBoard[line][colon].getValue() + " ");
                if((colon+1) % 3 == 0 && (colon+1) != 9)
                    System.out.print("| ");
            }

            System.out.print("|" +"\n");

            if((line+1) % 3 == 0 && (line+1) != 9)
                System.out.println("");
        }
    }
}

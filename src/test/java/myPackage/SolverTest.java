package myPackage;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SolverTest {

    int[][] board = {
            { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
            { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
            { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
            { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
            { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
            { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
            { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
            { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
    };

    Board mySdkBoard = new Board();
    Solver solverTest;

    public void init(){
        mySdkBoard.createBoard(board);
        solverTest = new Solver(mySdkBoard.getCellBoard());
    }

    @Test
    void findCellValue() {
        init();
        Square newSquare = new Square(0,0);
        newSquare.createSquareValuePossible(mySdkBoard.getCellBoard());

        boolean result = solverTest.findSetCellValue(0,1,newSquare);
        int actualCellValue = mySdkBoard.getCellBoard()[0][1].getValue();
        int exceptCellValue = 1;

        Assert.assertTrue(result);
        Assert.assertEquals(actualCellValue,exceptCellValue);

    }

    @Test
    void findCellValue2() {
        init();
        Square newSquare = new Square(6,0);
        newSquare.createSquareValuePossible(mySdkBoard.getCellBoard());

        boolean result = solverTest.findSetCellValue(8,1,newSquare);
        int actualCellValue = mySdkBoard.getCellBoard()[8][1].getValue();
        int exceptCellValue = 9;

        Assert.assertFalse(result);
        Assert.assertEquals(actualCellValue,exceptCellValue);

    }
}
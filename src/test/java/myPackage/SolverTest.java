package myPackage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeTest;

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

    Board mySdkBoard;
    Solver solverTest;
    Square newSquare;

    @BeforeTest
    public void init(){
        mySdkBoard = new Board();
        mySdkBoard.createBoard(board);
        solverTest = new Solver(mySdkBoard.getCellBoard());
        newSquare = new Square(0,0);
    }

    @Test
    void findCellValue() {
        init();

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

    @Test
    void moveBackMethodTest1(){
        init();

        int [] arrayExcept = {0,2};
        int [] arrayActual = solverTest.moveBackMethod(1, 2, newSquare);
        Assert.assertArrayEquals(arrayExcept, arrayActual);
    }

    @Test
    void moveBackMethodTest2(){
        init();

        int [] arrayExcept = {2,1};
        int [] arrayActual = solverTest.moveBackMethod(0, 2, newSquare);
        Assert.assertArrayEquals(arrayExcept, arrayActual);
    }

    @Test
    void moveBackMethodTest3(){
        init();

        int [] arrayExcept = {Solver.VALUE_NOT_OK,Solver.VALUE_NOT_OK};
        int [] arrayActual = solverTest.moveBackMethod(0, 0, newSquare);
        Assert.assertArrayEquals(arrayExcept, arrayActual);
    }


}
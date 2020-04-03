package myPackage;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SolverTest {
    private static Board mySdkBoard;
    private static Solver solverTest;
    private static Square newSquare;

    @BeforeAll
    public static void init(){
        mySdkBoard = new Board();
        mySdkBoard.createBoard(Main.board);
        mySdkBoard.createArrayWithSquares();
        solverTest = new Solver(mySdkBoard);
        newSquare = new Square(0,0);
        newSquare.createSquareValuePossible(mySdkBoard.getCellBoard());
    }


    /***
     * Check if value in line 0 and column 8 was find and modified to 1.
     */
    @Test
    void findCellValue() {
        boolean result = solverTest.findSetCellValue(0,8,newSquare);
        int actualCellValue = mySdkBoard.getCellBoard()[0][1].getValue();
        int exceptCellValue = 1;

        Assert.assertTrue(result);
        Assert.assertEquals(actualCellValue,exceptCellValue);

    }

    /***
     *  Check if value in line 8 and column 1 was not finding and don't changed it's value.
     */
    @Test
    void findCellValue2() {
        Square newSquare = new Square(6,0);
        newSquare.createSquareValuePossible(mySdkBoard.getCellBoard());

        boolean result = solverTest.findSetCellValue(8,1,newSquare);
        int actualCellValue = mySdkBoard.getCellBoard()[8][1].getValue();
        int exceptCellValue = 9;

        Assert.assertFalse(result);
        Assert.assertEquals(actualCellValue,exceptCellValue);

    }

    /***
     * Check if column 2 was decremented to 1.
     */
    @Test
    void moveBackMethodTest1(){
        int [] arrayExcept = {1,1};
        int [] arrayActual = solverTest.moveBackMethod(1, 2, newSquare);
        Assert.assertArrayEquals(arrayExcept, arrayActual);
    }

    /***
     * Check if line 2 was decremented to 1 and column equal 2.
     */
    @Test
    void moveBackMethodTest2(){
        int [] arrayExcept = {1,2};
        int [] arrayActual = solverTest.moveBackMethod(2, 0, newSquare);
        Assert.assertArrayEquals(arrayExcept, arrayActual);
    }

    /***
     * Check if line equal first line of square and column equal first column of square, decrementation is not available.
     */
    @Test
    void moveBackMethodTest3(){
        int [] arrayExcept = {Solver.VALUE_NOT_OK,Solver.VALUE_NOT_OK};
        int [] arrayActual = solverTest.moveBackMethod(0, 0, newSquare);
        Assert.assertArrayEquals(arrayExcept, arrayActual);
    }

    /***
     * Check column incrementation.
     */
    @Test
    void moveAhead(){
        int [] arrayExcept = {0,1};
        int [] arrayActual = solverTest.moveAhead(0, 0, newSquare);
        Assert.assertArrayEquals(arrayExcept, arrayActual);
    }

    /***
     * Check line incrementation.
     */
    @Test
    void moveAhead2(){
        int [] arrayExcept = {2,0};
        int [] arrayActual = solverTest.moveAhead(1, 2, newSquare);
        Assert.assertArrayEquals(arrayExcept, arrayActual);
    }

    /***
     * Check if line equal last line of square and column equal last column of square, incrementation is not available.
     */
    @Test
    void moveAhead3(){
        int [] arrayExcept = {Solver.VALUE_OK,Solver.VALUE_OK};
        int [] arrayActual = solverTest.moveAhead(2, 2, newSquare);
        Assert.assertArrayEquals(arrayExcept, arrayActual);
    }

    /***
     * Display resolved first square.
     */
    @Test
    void squareSolveTest(){
        solverTest.squareSolve(0, 0, 0);
        mySdkBoard.displayBoard();
    }
}
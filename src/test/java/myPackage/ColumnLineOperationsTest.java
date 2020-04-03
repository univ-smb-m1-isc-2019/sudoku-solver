package myPackage;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ColumnLineOperationsTest {

    private static Board mySdkBoard;
    private  static ColumnLineOperations ClOpTest;

    @BeforeAll
    public static void init(){
        mySdkBoard = new Board();
        mySdkBoard.createBoard(Main.board);
        ClOpTest = new ColumnLineOperations();
    }

    /***
     * Test if column 7 of the board does't has value 0.
     * Test if column 7 of the board does't has value 9.
     */
    @Test
    void columnTest() {
        Assert.assertFalse(ClOpTest.columnTest(mySdkBoard.getCellBoard(),7, 0));
        Assert.assertTrue(ClOpTest.columnTest(mySdkBoard.getCellBoard(),7, 9));
    }

    /***
     * Test if line 0 of the board does't has value 8.
     * Test if line 0 of the board does't has value 9.
     */
    @Test
    void lineTest() {
        Assert.assertFalse(ClOpTest.lineTest(mySdkBoard.getCellBoard(),0, 8));
        Assert.assertTrue(ClOpTest.lineTest(mySdkBoard.getCellBoard(),0, 9));
    }
}
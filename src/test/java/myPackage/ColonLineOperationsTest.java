package myPackage;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

class ColonLineOperationsTest {

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
    ColonLineOperations ClOpTest;

     public void init(){
        mySdkBoard.createBoard(board);
        ClOpTest = new ColonLineOperations();
    }


    @Test
    void colonTest() {
        init();
        Assert.assertFalse(ClOpTest.colonTest(mySdkBoard.getCellBoard(),7, 0, 1));
    }

    @Test
    void lineTest() {
        init();
        Assert.assertFalse(ClOpTest.lineTest(mySdkBoard.getCellBoard(),0, 8, 9));
    }
}
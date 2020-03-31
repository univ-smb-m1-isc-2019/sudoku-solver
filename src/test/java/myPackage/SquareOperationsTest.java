package myPackage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


class SquareOperationsTest {

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
   SquareOperations sqOpTest;

   @Before
   void init(){
       mySdkBoard.createBoard(board);
       sqOpTest = new SquareOperations();
   }

    @Test
    void findBiggestSquare() {
        init();
        int [] actualTest = sqOpTest.findBiggestSquare(mySdkBoard.getCellBoard() ,-1,-1);
        int actualTestI = actualTest[0];
        int actualTestJ = actualTest[1];

        int exceptTestI = 3;
        int exceptTestJ = 3;

        Assert.assertEquals(exceptTestI,actualTestI);
        Assert.assertEquals(actualTestJ,exceptTestJ);
    }

}
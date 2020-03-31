package myPackage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

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
    Square sq;

    @BeforeTest
    void init(){
        mySdkBoard = new Board();
        mySdkBoard.createBoard(board);
        sq = new Square(0,0);
    }

    @Test
    void createSquareValuePossible() {
        init();
        sq.createSquareValuePossible(mySdkBoard.getCellBoard());
        ArrayList<Integer> actualArray = sq.getValuesPossibleAll();
        ArrayList<Integer> actualArray2 = sq.getValuesPossibleActual();
        ArrayList<Integer> exceptArray = new ArrayList<>();
        exceptArray.add(1);
        exceptArray.add(2);
        exceptArray.add(4);
        exceptArray.add(5);
        exceptArray.add(6);
        exceptArray.add(9);

        Assert.assertArrayEquals(new ArrayList[]{exceptArray}, new ArrayList[]{actualArray});
        Assert.assertArrayEquals(new ArrayList[]{exceptArray}, new ArrayList[]{actualArray2});
    }

    @Test
    void checkSquareTest(){
        init();
        Assert.assertFalse(sq.checkSquare(mySdkBoard.getCellBoard(), sq, 8));
    }
}
package myPackage;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class SquareTest {

    private static Board mySdkBoard;
    private static Square newSquare;

    @BeforeAll
    public static void init(){
        mySdkBoard = new Board();
        mySdkBoard.createBoard(Main.board);
        newSquare = new Square(0,0);
        newSquare.createSquareValuePossible(mySdkBoard.getCellBoard());
    }

    /***
     * Check if method for creating array with values possible for squares, working well.
     */
    @Test
    void createSquareValuePossibleTest() {
        ArrayList<Integer> actualArray = newSquare.getValuesPossibleAll();
        ArrayList<Integer> exceptArray = new ArrayList<>();
        exceptArray.add(1);
        exceptArray.add(2);
        exceptArray.add(4);
        exceptArray.add(5);
        exceptArray.add(6);
        exceptArray.add(9);

        Assert.assertArrayEquals(new ArrayList[]{exceptArray}, new ArrayList[]{actualArray});
    }

    /***
     * Check if value 8 is not possible for the square because it already exists, and value 2 is possible.
     */
    @Test
    void checkSquareTest(){
        Assert.assertFalse(newSquare.checkSquare(mySdkBoard.getCellBoard(), newSquare, 8));
        Assert.assertTrue(newSquare.checkSquare(mySdkBoard.getCellBoard(), newSquare, 2));
    }
}
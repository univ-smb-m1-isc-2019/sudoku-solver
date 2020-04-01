package myPackage;

public class Main{
    public static void main(String[] args) {
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
        mySdkBoard.createBoard(board);

        Solver ms = new Solver(mySdkBoard);
        ms.createArrayWithSquares();
        ms.displayArrayWithSquares();

        ms.testSolve();
    }
}

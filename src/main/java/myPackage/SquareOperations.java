package myPackage;

public class SquareOperations {

    private boolean exceptionActualSquare(int vt, int hz, int vtExсept, int hzExсept){
        if((vtExсept != -1) && (hzExсept != -1)){
            return (vt == vtExсept &&  hz == hzExсept);
        }
        return false;
    }

    private int countNotEmptyCell(Cell[][] cellBoard, int vt, int hz){
        int countnb = 0;

        for(int i = vt; i < vt + 3 ; i++){
            for(int j = hz; j < hz + 3; j++){
                if(cellBoard[i][j].getValue() != 0 )
                    countnb++;
            }
        }

        if(countnb == 9){
            countnb = 0;
        }
        return countnb;
    }

    public int[] findBiggestSquare(Cell[][] cellBoard, int vtExсept, int hzExсept){
        int numberNotEmptyCell = 0;
        int[] positionOfBiggestSquare = new int[2];

        for(int i = 0; i < cellBoard.length ; i+=3){
            for(int j = 0; j < cellBoard.length; j+=3){

                if(!exceptionActualSquare(i, j, vtExсept, hzExсept)){
                    if(numberNotEmptyCell < countNotEmptyCell(cellBoard,i,j)){
                        numberNotEmptyCell = countNotEmptyCell(cellBoard,i,j);
                        positionOfBiggestSquare[0] = i;
                        positionOfBiggestSquare[1] = j;
                    }
                }
            }
        }
        return positionOfBiggestSquare;
    }

}

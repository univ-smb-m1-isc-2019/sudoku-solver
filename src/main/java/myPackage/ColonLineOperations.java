package myPackage;

public class ColonLineOperations {

    public boolean colonTest(Cell[][] cellBoard, int colon, int val){
        for (int i = 0; i < cellBoard.length; i++ ){
            if(cellBoard[i][colon].getValue()== val)
                return false;
        }
        return true;
    }

    public boolean lineTest(Cell[][] cellBoard, int line ,int val){
        for (int i = 0; i < cellBoard.length; i++ ){
            if(cellBoard[line][i].getValue() == val)
                return false;
        }
        return true;
    }
}

package pack;
import java.util.ArrayList;

//Instead of doing 3 classes ( square, row, column ) this class permit to regroup them into one.
//For those 3 classe we had 9 cells and for each cell in a column or row or square we had a number of possibilities, depending
//on row, column and square which contains the cell.
public class CellGroup {

    //The list of cells, representing the row  /  column  / square ( depending )
    private ArrayList<Cell> cellGroup;

    public CellGroup() {
        this.cellGroup = new ArrayList();
    }
    //Return the array of the possibilities, considering all the contents of the cells contained into this cellGroup
    public Integer[] getPossibilities(){
        ArrayList<Integer> possibilities = initPossibilities();
        //For each cell of this cellGroup, the cell content is removed from the possibilities
        for(Cell cell: cellGroup){
            possibilities.remove(Integer.valueOf(cell.getValue()));
        }
        return possibilities.toArray(new Integer[0]);
    }

    //This method return a list which contains a list with all the possibilities
    private ArrayList<Integer> initPossibilities(){
        ArrayList<Integer> possibilities = new ArrayList();
        for ( int i = 1 ; i <= 9 ; i ++){
            possibilities.add(i);
        }
        return possibilities;
    }

    //To add a cell in the list of cells
    public void add(Cell cell) {
        cellGroup.add(cell);
    }
    //Getter
    public ArrayList<Cell> getCellGroup() {
        return cellGroup;
    }
}

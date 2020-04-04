package usmb.info806.sudoku;


import java.util.ArrayList;
import java.util.Arrays;

public class Possibility {
    public boolean[] availablePossibility;

    public Possibility(){
    availablePossibility = new boolean[9];
    Arrays.fill(availablePossibility, Boolean.TRUE);
    }


    public void updatePossibility(ArrayList<Cell> cellList) {
        for (Cell cell: cellList) {
            if (cell.value != 0){
                availablePossibility[cell.value - 1] = false;
            }
        }
    }

    public int getSolution(){
        int i =0;
        if(nbPossibility() == 1){
            while(!this.availablePossibility[i]){
                i++;
            }
        }
        return i+1;
    }

    public int nbPossibility(){
        int nb = 0;
        for (int i = 0; i < availablePossibility.length; i++){
            if(availablePossibility[i])nb++;
        }
        return nb;
    }

    public void printPossibility(){
        for (int i = 0; i < availablePossibility.length; i++){
            System.out.println("id " + i + " : " + availablePossibility[i]);
        }
    }
}

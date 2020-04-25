package usmb.info806.sudoku;


import java.util.ArrayList;
import java.util.Arrays;

public class Possibility {
    public boolean[] availablePossibility;

    public Possibility(){
    availablePossibility = new boolean[9];
    Arrays.fill(availablePossibility, Boolean.TRUE);
    }

    public Possibility(boolean value){
        availablePossibility = new boolean[9];
        Arrays.fill(availablePossibility, value);
    }

    public int getSolution(){
        int i = 0;
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

    public int getPossibility(int nb){
        int i =0;
        if(nbPossibility() > 1) {
            while (!this.availablePossibility[i] || nb - 1 > 0) {
                if (this.availablePossibility[i]) {
                    nb--;
                }
                i++;
            }
        }else i = getSolution();
        return i+1;
    }

}

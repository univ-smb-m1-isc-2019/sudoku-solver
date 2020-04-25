package Sudoku;

import java.util.Arrays;

public class SolutionPossible {
    public boolean[] list;
    public SolutionPossible(){
        list = new boolean[9];
        Arrays.fill(list, Boolean.TRUE);
    }
    public SolutionPossible(boolean value){
        list = new boolean[9];
        Arrays.fill(list, value);
    }

    public int getSolutionPossibleNB(){
        int nb = 0;
        for (int i = 0; i < this.list.length; i++){
            if(list[i])nb++;
        }
        return nb;
    }

    public int getPossibility(){
        int i =0;
        if(getSolutionPossibleNB() == 1){
            while(!this.list[i]){
                i++;
            }
        }

        return i+1;
    }
    public int getPossibility(int nb){
        int i =0;
        if(getSolutionPossibleNB() > 1) {
            while (!this.list[i] || nb - 1 > 0) {
                if (this.list[i]) {
                    nb--;
                }
                i++;
            }
        }else i = getPossibility();
        return i+1;
    }

}

package main.java.SS;

import java.util.Arrays;

public class AvailablePossibilities {
    public boolean[] list;
    public AvailablePossibilities(){
        list = new boolean[9];
        Arrays.fill(list, Boolean.TRUE);
    }
    public AvailablePossibilities(boolean value){
        list = new boolean[9];
        Arrays.fill(list, value);
    }
    public void printPossibilities(){
        for (int i = 0; i < this.list.length; i++){
            System.out.println((i+1)+" "+this.list[i]);
        }
    }
    public int getAvailablePossibilitiesNB(){
        int nb = 0;
        for (int i = 0; i < this.list.length; i++){
            if(list[i])nb++;
        }
        return nb;
    }
    public int getSolution(){
        int i =0;
        if(getAvailablePossibilitiesNB() == 1){
            while(!this.list[i]){
                i++;
            }
        }
        System.out.print("result = "+i+1);
        return i+1;
    }
    public int getPossibility(){
        int i =0;
        if(getAvailablePossibilitiesNB() == 1){
            while(!this.list[i]){
                i++;
            }
        }

        return i+1;
    }
    public int getPossibility(int nb){
        int i =0;
        this.printPossibilities();
        if(getAvailablePossibilitiesNB() > 1) {
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

package Sudoku;


import java.util.ArrayList;

public class Backtracker {
    public ArrayList<BacktrackerItem> list;
    public Backtracker(){
        this.list = new ArrayList<BacktrackerItem>();
    }
    public void add(BacktrackerItem item){
        this.list.add(item);
    }

    public BacktrackerItem getderniersolve(){
        boolean trouve = false;
        int i = getSize()-1;
        while(!trouve && i >= 0){
            if(this.list.get(i).act < this.list.get(i).maximum){
                trouve = true;
            }else{
                i--;
            }
        }
        return this.list.get(i);
    }
    public int getSize(){
        return this.list.size();
    }
}

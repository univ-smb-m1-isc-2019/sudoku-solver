package usmb.info806.sudoku;

import java.util.ArrayList;

public class BackTracker {
    public ArrayList<BackTrackerItem> itemList;

    public BackTracker(){
        this.itemList = new ArrayList<BackTrackerItem>();
    }

    public void add(BackTrackerItem item){
        this.itemList.add(item);
    }

    public BackTrackerItem getLastAvailable(){
        boolean find= false;
        int i = itemList.size()-1;
        while(!find && i>= 0){
            if (itemList.get(i).value < itemList.get(i).maximum){
                find = true;
            }
            else{
                i--;
            }
        }
        return itemList.get(i);
    }
}

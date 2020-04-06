package SS;


import java.util.ArrayList;

public class Backtracker {
    public ArrayList<BacktrackerItem> list;
    public Backtracker(){
        this.list = new ArrayList<BacktrackerItem>();
    }
    public void add(BacktrackerItem item){
        this.list.add(item);
    }
    public BacktrackerItem getLast(){
        return this.list.get(this.list.size());
    }
    public boolean backtrackerAvailable(){
        boolean rtr = false;
        for(BacktrackerItem item : this.list){
            if(item.current < item.maximum) rtr = true;
        }
        return rtr;
    }
    public BacktrackerItem getLastAvailable(){
        boolean find = false;
        int i = getSize()-1;
        while(!find && i >= 0){
            if(this.list.get(i).current < this.list.get(i).maximum){
                find = true;
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

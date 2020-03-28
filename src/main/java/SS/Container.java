package main.java.SS;

import java.util.ArrayList;

public abstract class Container {
    public ArrayList<Case> list;
    public int id;
    public Container(){
        this.list = new ArrayList<Case>();
    }
    public Container(ArrayList<Case> List){
        this.list = List;
    }
    public ArrayList<Integer> getAvailable(){
        ArrayList<Integer> startList =  getAllNumbers();
        this.list.stream().forEach(i -> {
            if (startList.contains(i.value) && startList.get(i.value) != 0) {
                startList.set(i.value, 0);
            }
        });
        return startList;
    }
    public static ArrayList<Integer> getAllNumbers(){
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        for(int i = 1; i < 11; i++){
            numberList.add(i);
        }
        return numberList;
    }
    public void print(){
        this.list.stream().forEach(i -> {
            System.out.println(i.value);
        });
    }
}

package main.java.SS;

import java.util.ArrayList;

public class Column extends Container {
    public Column(){
        this.list =  new ArrayList<Case>();
    }
    public Column(int id){
        this.list =  new ArrayList<Case>();
        this.id = id;
    }
    public Column(ArrayList<Case> Column) {
        ArrayList<Case> finalLine = new ArrayList<Case>();
        Column.stream().forEach(j -> {
            finalLine.add(j);
        });
        this.list = finalLine;
    }
}

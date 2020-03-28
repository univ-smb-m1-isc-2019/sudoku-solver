package main.java.SS;

import java.util.ArrayList;

public class Line extends Container {
    public Line(){
        this.list =  new ArrayList<Case>();
    }
    public Line(int id){
        this.list =  new ArrayList<Case>();
        this.id = id;
    }
    public Line(ArrayList<Case> line){
        ArrayList<Case> finalLine = new ArrayList<Case>();
        line.stream().forEach(j -> {
            finalLine.add(j);
        });
        this.list = finalLine;
    }

}

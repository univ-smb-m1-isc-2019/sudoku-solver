package main.java.SS;

import java.util.ArrayList;
import java.util.Arrays;

public class Line extends Container {
    public Line(){
        this.list =  new ArrayList<Case>();
    }
    public Line(ArrayList<Case> line){
        ArrayList<Case> finalLine = new ArrayList<Case>();
        line.stream().forEach(j -> {
            finalLine.add(j);
        });
        this.list = finalLine;
    }

}

package main.java.SS;

import java.util.ArrayList;
import java.util.Arrays;

public class Column extends Container {
    public Column(){
        this.list =  new ArrayList<Case>();
    }
    public Column(ArrayList<Case> Column) {
        ArrayList<Case> finalLine = new ArrayList<Case>();
        Column.stream().forEach(j -> {
            finalLine.add(j);
        });
        this.list = finalLine;
    }
}

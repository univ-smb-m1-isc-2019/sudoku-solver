package main.java.SS;

import java.util.ArrayList;
import java.util.Arrays;

public class Line extends Container {
    public Line(ArrayList<Case> List){
        this.list = List;
    }
    public Line(Integer[] line){
        ArrayList<Case> finalLine = new ArrayList<Case>();
        Arrays.stream(line).forEach(j -> {
            finalLine.add(new Case(j));
        });
        this.list = finalLine;
    }

    public Line(int[] line) {
        ArrayList<Case> finalLine = new ArrayList<Case>();
        Arrays.stream(line).forEach(j -> {
            finalLine.add(new Case(j));
        });
        this.list = finalLine;
    }
}

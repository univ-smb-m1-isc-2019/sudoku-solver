package SS;

import java.util.ArrayList;
public class Square extends Container {
    public Square(){
        this.list =  new ArrayList<Case>();
    }
    public Square(int id){
        this.list =  new ArrayList<Case>();
        this.id = id;
    }
    public Square(ArrayList<Case> line){
        ArrayList<Case> finalLine = new ArrayList<Case>();
        line.stream().forEach(j -> {
            finalLine.add(j);
        });
        this.list = finalLine;
    }
}

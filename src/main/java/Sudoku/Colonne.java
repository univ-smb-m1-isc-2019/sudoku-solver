package Sudoku;

import java.util.ArrayList;

public class Colonne extends Container {
    public Colonne(int id){
        this.list =  new ArrayList<Case>();
        this.id = id;
    }

}

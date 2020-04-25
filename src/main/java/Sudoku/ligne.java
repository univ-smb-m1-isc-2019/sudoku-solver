package Sudoku;

import java.util.ArrayList;

public class ligne extends Container {
    public ligne(int id){
        this.list =  new ArrayList<Case>();
        this.id = id;
    }


}
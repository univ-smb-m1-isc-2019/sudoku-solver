package fr.nathanchevallier;

import java.util.ArrayList;
import java.util.List;

public class Box {
    public int number;
    public int line;
    public int column;
    public Region region;

    boolean valid;
    public List<Integer> possibleNumbers = new ArrayList<Integer>();

    public Box(int number, int line, int column, Region region){
        this.number = number;
        this.line = line;
        this.column = column;
        this.region = region;
        if(this.number != 0)
            this.valid = true;
        else{
            this.valid = false;
            for(int i=1; i <= 9; i++){
                this.possibleNumbers.add(i);
            }
        }

    }

    public void updateNumber(){
        if(this.possibleNumbers.size() == 1){
            this.number = this.possibleNumbers.get(0);
            this.possibleNumbers.clear();
            this.valid = true;
        }

    }

    public void updateListPossibleNumbers(Box[][] grid){
        this.possibleNumbers.removeAll(this.areaList(grid));
    }

    public boolean sameListMembers(Box box){
        return this.possibleNumbers.containsAll(box.possibleNumbers);
    }

    public void cleanPossibleNumbers(){
        if(this.valid && this.possibleNumbers != null)
            this.possibleNumbers.clear();
    }


    public boolean isInArea(int num, Box[][] grid){
        if(this.areaList(grid).contains(num))
            return true;
        else
            return false;
    }

    public List<Integer> areaList(Box[][] grid){
        List<Integer> list = new ArrayList<Integer>();
        list.addAll(areaLine(grid));
        list.addAll(areaColumn(grid));
        list.addAll(this.region.areaRegion(grid, this.line, this.column));

        return list;
    }

    public List<Integer> areaLine(Box[][] grid){
        List<Integer> listLine = new ArrayList<Integer>();
        for(int i=0; i <= 8; i++){
            if(this.column != i && grid[this.line][i].valid)
                listLine.add(grid[this.line][i].number);
        }
        return listLine;
    }

    public List<Integer> areaColumn(Box[][] grid){
        List<Integer> listColumn = new ArrayList<Integer>();
        for(int i=0; i <= 8; i++){
            if(this.line != i && grid[i][this.column].valid)
                listColumn.add(grid[i][this.column].number);
        }
        return listColumn;
    }

    public void displays_possibleNumbers(){
        for(int element : this.possibleNumbers){
            System.out.print(element);
        }
    }

}

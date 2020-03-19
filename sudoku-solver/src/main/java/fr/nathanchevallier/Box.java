package fr.nathanchevallier;

import java.util.ArrayList;
import java.util.List;

public class Box {
    int number;
    int line;
    int column;
    int[] region;

    boolean valid;
    List<Integer> possibleNumbers = new ArrayList<Integer>();

    public Box(int number, int line, int column){
        this.number = number;
        this.line = line;
        this.column = column;
        this.region = findRegion(this.line, this.column);
        if(this.number != 0)
            this.valid = true;
        else{
            this.valid = false;
            for(int i=1; i <= 9; i++){
                this.possibleNumbers.add(i);
            }
        }

    }


    public int[] findRegion(int line, int column){
        if(line >= 0 && line <= 2 && column >= 0 && column <= 2)
            return new int[]{0, 2, 0, 2};
        if(line >= 0 && line <= 2 && column >= 3 && column <= 5)
            return new int[]{0, 2, 3, 5};
        if(line >= 0 && line <= 2 && column >= 6 && column <= 8)
            return new int[]{0, 2, 6, 8};

        if(line >= 3 && line <= 5 && column >= 0 && column <= 2)
            return new int[]{3, 5, 0, 2};
        if(line >= 3 && line <= 5 && column >= 3 && column <= 5)
            return new int[]{3, 5, 3, 5};
        if(line >= 3 && line <= 5 && column >= 6 && column <= 8)
            return new int[]{3, 5, 6, 8};

        if(line >= 6 && line <= 8 && column >= 0 && column <= 2)
            return new int[]{6, 8, 0, 2};
        if(line >= 6 && line <= 8 && column >= 3 && column <= 5)
            return new int[]{6, 8, 3, 5};
        else
            return new int[]{6, 8, 6, 8};
    }

    public boolean isInArea(int num, Box[][] grid){
        if(areaList(grid).contains(num))
            return true;
        else
            return false;
    }

    public List<Integer> areaList(Box[][] grid){
        List<Integer> list = new ArrayList<Integer>();
        list.addAll(areaLine(grid));
        list.addAll(areaColumn(grid));
        list.addAll(areaRegion(grid));

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
    public List<Integer> areaRegion(Box[][] grid){
        List<Integer> listColumn = new ArrayList<Integer>();
        for(int i=this.region[0]; i <= this.region[1]; i++){
            for(int j=this.region[2]; j <= this.region[3]; j++){
                if( grid[i][j].valid && !(this.line == i && this.column == j))
                    listColumn.add(grid[i][j].number);
            }

        }
        return listColumn;
    }
}

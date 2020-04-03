package fr.nathanchevallier;

import java.util.ArrayList;
import java.util.List;

public class Region {
    public int id;
    public int minLine;
    public int maxLine;
    public int minColumne;
    public int maxColumne;


    public Region(int id){
        this.id = id;
        int[] tab = addPosition(id);
        this.minLine = tab[0];
        this.maxLine = tab[1];
        this.minColumne = tab[2];
        this.maxColumne = tab[3];
    }


    public int[] addPosition(int id){
        switch (id) {
            case 1:  return new int[]{0, 2, 0, 2};
            case 2:  return new int[]{0, 2, 3, 5};
            case 3:  return new int[]{0, 2, 6, 8};
            case 4:  return new int[]{3, 5, 0, 2};
            case 5:  return new int[]{3, 5, 3, 5};
            case 6:  return new int[]{3, 5, 6, 8};
            case 7:  return new int[]{6, 8, 0, 2};
            case 8:  return new int[]{6, 8, 3, 5};
            case 9:  return new int[]{6, 8, 6, 8};
            default: return null;
        }
    }


    public List<Integer> areaRegion(Box[][] grid, int line, int column){
        List<Integer> listColumn = new ArrayList<Integer>();
        for(int i=this.minLine; i <= this.maxLine; i++){
            for(int j=this.minColumne; j <= this.maxColumne; j++){
                if( grid[i][j].valid && !(line == i && column == j))
                    listColumn.add(grid[i][j].number);
            }

        }
        return listColumn;
    }

    public List<Box> listInRegion(Box[][] grid){
        List<Box> list = new ArrayList<Box>();
        for(int i=this.minLine; i <= this.maxLine; i++){
            for(int j=this.minColumne; j <= this.maxColumne; j++){
                if( !(grid[i][j].valid) && (grid[i][j].possibleNumbers.size() <= 2))
                    list.add(grid[i][j]);
            }
        }
        return list;
    }
}

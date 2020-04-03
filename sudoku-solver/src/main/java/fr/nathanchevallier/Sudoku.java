package fr.nathanchevallier;

import java.util.ArrayList;
import java.util.List;

public class Sudoku {

    public static final int SUDOKU_SIZE = 9;
    public Box[][] SudokuGrid = new Box[9][9];
    public List<Region> listRegion = new ArrayList<Region>();

    public Sudoku(int[][] grid){
        listRegion.add(new Region(1));
        listRegion.add(new Region(2));
        listRegion.add(new Region(3));
        listRegion.add(new Region(4));
        listRegion.add(new Region(5));
        listRegion.add(new Region(6));
        listRegion.add(new Region(7));
        listRegion.add(new Region(8));
        listRegion.add(new Region(9));

        for(int i=0; i < grid.length; i++){
            for(int j=0; j < grid[i].length; j++){
                this.SudokuGrid[i][j] = new Box(grid[i][j], i, j, listRegion.get(findRegion(i,j)-1));
            }
        }
        for(int i=0; i < this.SudokuGrid.length; i++){
            for(int j=0; j < this.SudokuGrid[i].length; j++){
                if(!(this.SudokuGrid[i][j].valid)){
                    this.SudokuGrid[i][j].updateListPossibleNumbers(SudokuGrid);
                   // this.SudokuGrid[i][j].updateNumber();
                }
            }
        }
    }

    public boolean isValid() {
        for(int i=0; i < this.SudokuGrid.length; i++){
            for(int j=0; j < this.SudokuGrid[i].length; j++){
                if(this.SudokuGrid[i][j].valid){
                    if(this.SudokuGrid[i][j].isInArea(this.SudokuGrid[i][j].number, this.SudokuGrid))
                        return false;
                }
            }
        }
        return true;
    }

    public boolean isResolvedCorrectly() {
        for(int i=0; i < this.SudokuGrid.length; i++){
            for(int j=0; j < this.SudokuGrid[i].length; j++){
                if(!(this.SudokuGrid[i][j].valid)){
                    return false;
                }
            }
        }
        if(!(this.isValid()))
            return false;

        return true;
    }

    public void solve() {
        int x =0;
        while (x <= 4){
            for(int i=0; i < this.SudokuGrid.length; i++){
                for(int j=0; j < this.SudokuGrid[i].length; j++){
                    if(!(this.SudokuGrid[i][j].valid)){
                        this.SudokuGrid[i][j].updateListPossibleNumbers(SudokuGrid);
                        this.SudokuGrid[i][j].updateNumber();
                        single_nb_in_area(this.SudokuGrid[i][j]);
                    }
                }

            }

//            for(int i=0; i <= 8; i++){
//                this.doubleLine(i);
//                this.doubleColumn(i);
//                this.doubleRegion(this.listRegion.get(i));
//            }
            x = x+1;
        }
    }

    public void single_nb_in_area(Box box){
        for (int i = 0; i <= box.possibleNumbers.size() -1; i++){
            this.single_nb_line(box.possibleNumbers.get(i),box.line, box.column);
        }
    }
    public void single_nb_line(int nbsearch, int line, int column){
        boolean same_number = false;
        for (int c = 0; c <= SUDOKU_SIZE-1; c++){
            if(!(this.SudokuGrid[line][c].valid) && (c != column)){
                if(this.SudokuGrid[line][c].possibleNumbers.contains(nbsearch))
                    same_number = true;
            }

        }
        if(!same_number){
            this.SudokuGrid[line][column].number = nbsearch;
            this.SudokuGrid[line][column].valid = true;
        }

    }
    public void single_nb_column(int nbsearch, int line, int column){
    }

    public void single_nb_region(Box box){

    }

    public void doubleLine(int line){
        List<Box> list = new ArrayList<Box>();
        list = this.listInLine(line);
        list = this.duplicate(list);
        for(int i=0; i <= 8; i++){
            if(!(this.SudokuGrid[line][i].valid) && (this.SudokuGrid[line][i] != list.get(0)) && (this.SudokuGrid[line][i] != list.get(1))){
                this.SudokuGrid[line][i].possibleNumbers.removeAll(list.get(0).possibleNumbers);
            }

        }
    }

    public void doubleColumn(int column){
        List<Box> list = new ArrayList<Box>();
        list = this.listInColumn(column);
        list = this.duplicate(list);
        for(int i=0; i <= 8; i++){
            if(!(this.SudokuGrid[i][column].valid) && (this.SudokuGrid[i][column] != list.get(0)) && (this.SudokuGrid[i][column] != list.get(1))){
                this.SudokuGrid[i][column].possibleNumbers.removeAll(list.get(0).possibleNumbers);
            }

        }
    }

    public void doubleRegion(Region region){
        List<Box> list = new ArrayList<Box>();
        list = region.listInRegion(this.SudokuGrid);
        list = this.duplicate(list);
        for(int i = region.minLine; i <= region.maxLine; i++){
            for(int j=region.minColumne; j <= region.maxColumne; j++){
                if(!(this.SudokuGrid[i][j].valid) && (this.SudokuGrid[i][j] != list.get(0)) && (this.SudokuGrid[i][j] != list.get(1))){
                    this.SudokuGrid[i][j].possibleNumbers.removeAll(list.get(0).possibleNumbers);
                }
            }
        }
    }

    public List<Box> duplicate(List<Box> list){
        List<Box> listBoxDouble = new ArrayList<Box>();
        if(!list.isEmpty() && list.size() >= 2 ){
            boolean nofini = true;
            while(nofini){
                for(int i=0; i < list.size(); i++){
                    for(int j=i+1; j < list.size(); i++){
                         if(list.get(i).sameListMembers(list.get(j))){
                            listBoxDouble.add((list.get(i)));
                            listBoxDouble.add((list.get(j)));
                        }
                    }
                }
            }

        }
        return listBoxDouble;

    }

    public List<Box> listInLine(int line){
        List<Box> list = new ArrayList<Box>();
        for(int i=0; i <= 8; i++){
            if(!(this.SudokuGrid[line][i].valid) && (this.SudokuGrid[line][i].possibleNumbers.size() <= 2))
                list.add(this.SudokuGrid[line][i]);
        }
        return list;
    }

    public List<Box> listInColumn(int column){
        List<Box> list = new ArrayList<Box>();
        for(int i=0; i <= 8; i++){
            if(!(this.SudokuGrid[i][column].valid) && (this.SudokuGrid[i][column].possibleNumbers.size() <= 2))
                list.add(this.SudokuGrid[i][column]);
        }
        return list;
    }




    public void showGrid(){
        for(int i=0; i < this.SudokuGrid.length; i++){
            for(int j=0; j < this.SudokuGrid[i].length; j++){
                System.out.print( this.SudokuGrid[i][j].number + " ");
            }
            System.out.println();
        }
    }


    public int findRegion(int line, int column){
        if(line >= 0 && line <= 2 && column >= 0 && column <= 2)
            return 1;
        if(line >= 0 && line <= 2 && column >= 3 && column <= 5)
            return 2;
        if(line >= 0 && line <= 2 && column >= 6 && column <= 8)
            return 3;
        if(line >= 3 && line <= 5 && column >= 0 && column <= 2)
            return 4;
        if(line >= 3 && line <= 5 && column >= 3 && column <= 5)
            return 5;
        if(line >= 3 && line <= 5 && column >= 6 && column <= 8)
            return 6;
        if(line >= 6 && line <= 8 && column >= 0 && column <= 2)
            return 7;
        if(line >= 6 && line <= 8 && column >= 3 && column <= 5)
            return 8;
        else
            return 9;
    }

}

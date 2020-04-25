package fr.nathanchevallier;

import java.util.ArrayList;
import java.util.List;

public class SaveChoice {
    public int[][] grid ;
    public List<Integer>[][] ListPossibleNumbers;
    public Box selectBox;
    public int choice;
    public int nbChoice;
    public String[][] PossibleNumbers;

    public SaveChoice(Box[][] SudokuGrid, Box selectBox){
        this.grid = this.convertGrid(SudokuGrid);
        this.PossibleNumbers = this.convertListPossibleNumbers(SudokuGrid);
       // this.ListPossibleNumbers = this.convertListPossibleNumbers(SudokuGrid);
        this.selectBox = new Box(selectBox.number, selectBox.line, selectBox.column, selectBox.region, selectBox.possibleNumbers, selectBox.valid);
        this.choice = 0;
        this.nbChoice = selectBox.possibleNumbers.size();
    }
    public int getChoice(){
        return this.choice;
    }
    public void setChoice(int newChoice){
        this.choice = newChoice;
    }

    public int[][] convertGrid(Box[][] grid){
        int[][] resGrid = new int[9][9];
        for(int i=0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                resGrid[i][j] = grid[i][j].number;
            }
        }
        return resGrid;
    }

    public String[][] convertListPossibleNumbers(Box[][] grid){
        String[][] resGrid = new String[81][2];
        int x = 0;
        for(int i=0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                resGrid[x][0] = Integer.toString(i) + Integer.toString(j);
                resGrid[x][1] = this.ListToString(grid[i][j].possibleNumbers);
                x = x +1;
            }
        }
        return resGrid;
    }

    public String ListToString(List<Integer> list){
        String strList = "";
        for(int element : list){
            strList = strList + Integer.toString(element);
        }
        return strList;
    }

    public List<Integer> ChangePossibleNumbers(int x, int y){
        List<Integer> res = new ArrayList<Integer>();
        for(String[] element : this.PossibleNumbers){
            if(element[0].equals(Integer.toString(x) + Integer.toString(y))){
                if(element[1] != ""){
                    String tab[] = element[1].split("");
                    for(String character : tab){
                        res.add(Integer.parseInt(character));
                    }
                }
//                else{
//                    res = null;
//                }
            }
        }
        return res;
    }


//    public List<Integer>[][] convertListPossibleNumbers(Box[][] grid){
//        List<Integer>[][] resGrid = new List[9][9];
//        for(int i=0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                resGrid[i][j] = grid[i][j].possibleNumbers;
//            }
//        }
//        return resGrid;
//    }

    public boolean isChoice(int newChoice){
        if(newChoice <= this.nbChoice)
            return true;
        else
            return false;
    }

    public Box getSelectBox(){
        return this.selectBox;
    }

    public int[][] getGrid(){
        return this.grid;
    }

    public int getNumber(){
        return this.selectBox.possibleNumbers.get(choice);
    }

    public Box[][] retrunOldBackup(Box[][] SudokuGrid){
        for(int i=0; i < SudokuGrid.length; i++) {
            for (int j = 0; j < SudokuGrid[i].length; j++) {
                SudokuGrid[i][j].number = this.grid[i][j];
                //SudokuGrid[i][j].possibleNumbers = this.ListPossibleNumbers[i][j];
                SudokuGrid[i][j].possibleNumbers = this.ChangePossibleNumbers(i,j);
                if(SudokuGrid[i][j].number == 0)
                    SudokuGrid[i][j].valid = false;
                else
                    SudokuGrid[i][j].valid = true;
            }
        }
        return SudokuGrid;
    }
}

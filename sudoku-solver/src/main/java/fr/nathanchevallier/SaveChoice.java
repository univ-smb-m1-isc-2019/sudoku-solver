package fr.nathanchevallier;

import java.util.ArrayList;
import java.util.List;

public class SaveChoice {
    public int[][] grid ;
    public List<Integer>[][] ListPossibleNumbers;
    public Box selectBox;
    public int choice;
    public int nbChoice;

    public SaveChoice(Box[][] SudokuGrid, Box selectBox){
        this.grid = this.convertGrid(SudokuGrid);
        this.ListPossibleNumbers = this.convertListPossibleNumbers(SudokuGrid);
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

    public List<Integer>[][] convertListPossibleNumbers(Box[][] grid){
        List<Integer>[][] resGrid = new List[9][9];
        for(int i=0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                resGrid[i][j] = grid[i][j].possibleNumbers;
            }
        }
        return resGrid;
    }

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
                SudokuGrid[i][j].possibleNumbers = this.ListPossibleNumbers[i][j];
                if(SudokuGrid[i][j].number == 0)
                    SudokuGrid[i][j].valid = false;
                else
                    SudokuGrid[i][j].valid = true;
            }
        }
        return SudokuGrid;
    }
}

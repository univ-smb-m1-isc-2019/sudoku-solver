package fr.nathanchevallier;

public class SaveChoice {
    public int[][] grid ;
    public Box selectBox;
    public int choice;
    public int nbChoice;

    public SaveChoice(int[][] grid, Box selectBox){
        this.grid = grid;
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
}

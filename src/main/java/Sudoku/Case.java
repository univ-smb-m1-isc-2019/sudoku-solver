package Sudoku;

public class Case {
    public int value;
    public int x;
    public int y;
    public SolutionPossible SolutionPossible;

    public Case(int value, int x, int y){
        this.value = value;
        this.x = x;
        this.y = y;
    }
    public Case(int value, int x, int y, boolean bool){
        this.value = value;
        this.x = x;
        this.y = y;
        this.SolutionPossible = new SolutionPossible(false);
    }
    public int getLigneID(){
        return this.y;
    }
    public int getColonneID(){
        return this.x;
    }
    public int getcarreID(){
        return (this.x/3)+(this.y/3)*3;
    }


}

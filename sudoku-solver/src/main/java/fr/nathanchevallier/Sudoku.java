package fr.nathanchevallier;

public class Sudoku {

    public Box[][] SudokuGrid = new Box[9][9];

    public Sudoku(int[][] grid){

        for(int i=0; i < grid.length; i++){
            for(int j=0; j < grid[i].length; j++){
                this.SudokuGrid[i][j] = new Box(grid[i][j], i, j);
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

    public void showGrid(){
        for(int i=0; i < this.SudokuGrid.length; i++){
            for(int j=0; j < this.SudokuGrid[i].length; j++){
                System.out.print( this.SudokuGrid[i][j].number + " ");
            }
            System.out.println();
        }
    }
}

package SolverSudoku;

import java.util.ArrayList;
import java.util.List;

public class Region {
    public int id;
    public int minLine;
    public int maxLine;
    public int minColumne;
    public int maxColumne;


    // BUILDER
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

    public void single_nb_region(int nbsearch, int line, int column, Sudoku sudo){
        boolean same_number = false;
        int[] tabPosition = addPosition(sudo.findRegion(line, column));
        for (int l = tabPosition[0]; l <= tabPosition[1]; l++){
            for (int c = tabPosition[2]; c <= tabPosition[3]; c++){
                if(!(sudo.SudokuGrid[l][c].valid) ){
                    if( (l != line && c != column) || (l == line && c != column) || (l != line && c == column) ){
                        if(sudo.SudokuGrid[l][c].possibleNumbers.contains(nbsearch))
                            same_number = true;
                    }

                }
            }
        }
        if(!same_number){
            sudo.SudokuGrid[line][column].changeBox(nbsearch);
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

    public void doubleInRegion(Box[][] grid, Sudoku sudo){
        List<Box> list = new ArrayList<Box>();
        for(int i=this.minLine; i <= this.maxLine; i++){
            for(int j=this.minColumne; j <= this.maxColumne; j++){
                if( !(grid[i][j].valid) && (grid[i][j].possibleNumbers.size() <= 2))
                    list.add(grid[i][j]);
            }
        }
        if (!list.isEmpty()){
            for(Box element : list){
                for(Box other : list){
                    if((element != other) && element.sameListMembers(other)){
                        for(int l=this.minLine; l <= this.maxLine; l++){
                            for(int c=this.minColumne; c<= this.maxColumne; c++){
                                if(!(sudo.SudokuGrid[l][c].valid) && (l!=element.line && c!=element.column) && (l!=other.line && c!=other.column) ){
                                    for(int nb : element.possibleNumbers){
                                        if(sudo.SudokuGrid[l][c].possibleNumbers.contains(nb))
                                            sudo.SudokuGrid[l][c].possibleNumbers.remove((Object)nb);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
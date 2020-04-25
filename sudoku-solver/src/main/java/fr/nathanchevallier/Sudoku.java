package fr.nathanchevallier;

import java.util.ArrayList;
import java.util.List;

public class Sudoku {

    public static final int SUDOKU_SIZE = 9;
    public Box[][] SudokuGrid = new Box[9][9];
    public List<Region> listRegion = new ArrayList<Region>();
    public List<SaveChoice> saveGrid = new ArrayList<SaveChoice>();

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

        this.createSudokuGrid(grid);

        for(int i=0; i < this.SudokuGrid.length; i++){
            for(int j=0; j < this.SudokuGrid[i].length; j++){
                if(!(this.SudokuGrid[i][j].valid)){
                    this.SudokuGrid[i][j].updateListPossibleNumbers(SudokuGrid);
                   // this.SudokuGrid[i][j].updateNumber();
                }
            }
        }
    }

    public void createSudokuGrid(int[][] grid){
        for(int i=0; i < grid.length; i++){
            for(int j=0; j < grid[i].length; j++){
                this.SudokuGrid[i][j] = new Box(grid[i][j], i, j, listRegion.get(findRegion(i,j)-1));
            }
        }
    }
    public int[][] convertGrid(Box[][] grid){
        int[][] resGrid= new int[9][9];
        for(int i=0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                resGrid[i][j] = grid[i][j].number;
            }
        }
        return resGrid;
    }

    // Main method of resolve
    public void solve() {
        boolean fini = false;
        //this.showGrid();
        int[][] saveGrid = this.convertGrid(this.SudokuGrid);

        for(int i=0; i < this.SudokuGrid.length; i++){
            for(int j=0; j < this.SudokuGrid[i].length; j++){
                this.SudokuGrid[i][j].cleanPossibleNumbers();
                if(!(this.SudokuGrid[i][j].valid)){
                    this.SudokuGrid[i][j].updateListPossibleNumbers(SudokuGrid);
                    this.SudokuGrid[i][j].updateNumber();
                    single_nb_in_area(this.SudokuGrid[i][j]);
                }
            }

        }

        for (int elem = 0; elem < SUDOKU_SIZE; elem++){
            this.doubleInLine(elem);
            this.doubleInColumn(elem);
            this.listRegion.get(elem).doubleInRegion(SudokuGrid, this);
        }

        // affichage
//        this.showGrid();
//        this.show_possibleNumbers_Grid();


        if( this.isResolvedCorrectly() )
            this.showGrid();
        else{
            if(this.isEqualToGrid(saveGrid)){
               // System.out.println(" Rentre dans sauvgarde ");
                this.randomNumber2();

               // this.randomNumber();
               // this.solve();
            }
            else {
                this.solve();
            }
        }

    }

    public void randomNumber2(){
        Box choiceBox = boxLeastChoice();

        if(choiceBox.getSizePossibleNumbers() == 2){
            // Créate new sudoku
            Sudoku newSudoku = new Sudoku(this.convertGrid(this.SudokuGrid));

            //
            this.SudokuGrid[choiceBox.line][choiceBox.column].changeBox(choiceBox.getNumberPossibleNumbers(0));
            newSudoku.SudokuGrid[choiceBox.line][choiceBox.column].changeBox(choiceBox.getNumberPossibleNumbers(1));

            //
            this.solve();
            newSudoku.solve();

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

    public void single_nb_in_area(Box box){
        for(int element : box.possibleNumbers){
            this.single_nb_line(element,box.line, box.column);
            this.single_nb_column(element,box.line, box.column);
            box.region.single_nb_region(element,box.line, box.column,this);
        }
    }
    public void single_nb_line(int nbsearch, int line, int column){
        boolean same_number = false;
        for (int c = 0; c < SUDOKU_SIZE; c++){
            if(!(this.SudokuGrid[line][c].valid) && (c != column)){
                if(this.SudokuGrid[line][c].possibleNumbers.contains(nbsearch))
                    same_number = true;
            }
        }
        if(!same_number){
            this.SudokuGrid[line][column].changeBox(nbsearch);
        }
    }

    public void single_nb_column(int nbsearch, int line, int column){
        boolean same_number = false;
        for (int l = 0; l < SUDOKU_SIZE; l++){
            if(!(this.SudokuGrid[l][column].valid) && (l != line)){
                if(this.SudokuGrid[l][column].possibleNumbers.contains(nbsearch))
                    same_number = true;
            }
        }
        if(!same_number){
            this.SudokuGrid[line][column].changeBox(nbsearch);
        }
    }


    public void showGrid(){
        for(int i=0; i < SUDOKU_SIZE; i++){
            for(int j=0; j < SUDOKU_SIZE; j++){
                System.out.print( this.SudokuGrid[i][j].number + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public void show_possibleNumbers_Grid(){
        for(int i=0; i < SUDOKU_SIZE; i++){
            for(int j=0; j < SUDOKU_SIZE; j++){
                this.SudokuGrid[i][j].displays_possibleNumbers();
                System.out.print("  |  ");
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


    public boolean isEqualToGrid(int[][] grid){
        int[][] newGrid = this.convertGrid(this.SudokuGrid);
        for(int i=0; i < SUDOKU_SIZE; i++) {
            for (int j = 0; j < SUDOKU_SIZE; j++) {
                if( newGrid[i][j] != grid[i][j])
                    return false;
            }
        }
        return true;
    }

    public void doubleInLine(int line){
        List<Box> list = new ArrayList<Box>();
        for(int i=0; i<SUDOKU_SIZE; i++){
            if(!(this.SudokuGrid[line][i].valid) && (this.SudokuGrid[line][i].possibleNumbers.size() <= 2))
                list.add(this.SudokuGrid[line][i]);
        }
        if (!list.isEmpty()){
            for(Box element : list){
                for(Box other : list){
                    if((element != other) && element.sameListMembers(other)){
                        for(int c=0; c<SUDOKU_SIZE; c++){
                            if(!(this.SudokuGrid[line][c].valid) && c!=element.column && c!=other.column){
                                for(int nb : element.possibleNumbers){
                                    if(this.SudokuGrid[line][c].possibleNumbers.contains(nb))
                                        this.SudokuGrid[line][c].possibleNumbers.remove((Object)nb);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void doubleInColumn(int column){
        List<Box> list = new ArrayList<Box>();
        for(int i=0; i <= 8; i++){
            if(!(this.SudokuGrid[i][column].valid) && (this.SudokuGrid[i][column].possibleNumbers.size() <= 2))
                list.add(this.SudokuGrid[i][column]);
        }
        if (!list.isEmpty()){
            for(Box element : list){
                for(Box other : list){
                    if((element != other) && element.sameListMembers(other)){
                        for(int l=0; l<SUDOKU_SIZE; l++){
                            if(!(this.SudokuGrid[l][column].valid) && l!=element.line && l!=other.line){
                                for(int nb : element.possibleNumbers){
                                    if(this.SudokuGrid[l][column].possibleNumbers.contains(nb))
                                        this.SudokuGrid[l][column].possibleNumbers.remove((Object)nb);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public void randomNumber(){
        Box choiceBox = boxLeastChoice();
        int newNumber;
        if(choiceBox.getSizePossibleNumbers() == 2){
            this.saveGrid.add(new SaveChoice(this.getSudokuGrid(),choiceBox));
            newNumber = this.saveGrid.get(this.saveGrid.size()-1).getNumber();
            this.SudokuGrid[choiceBox.line][choiceBox.column].changeBox(newNumber);
        }
        else{
            boolean find = false;
            while(!find){
                int nbTarget = this.saveGrid.get(this.saveGrid.size()-1).getChoice();
                if(nbTarget == 0){
                    System.out.println(" CHOIX 2 !!!");
                    this.saveGrid.get(this.saveGrid.size()-1).setChoice(1);
                    this.SudokuGrid = this.saveGrid.get(this.saveGrid.size()-1).retrunOldBackup(this.getSudokuGrid());
                    for(int i=0; i < this.SudokuGrid.length; i++){
                        for(int j=0; j < this.SudokuGrid[i].length; j++){
                            if(!(this.SudokuGrid[i][j].valid)){
                                this.SudokuGrid[i][j].updateListPossibleNumbers(SudokuGrid);
                                // this.SudokuGrid[i][j].updateNumber();
                            }
                        }
                    }
                    find = true;
                }
                else{
                    System.out.println(" SUPP DERNIER ");
                    this.saveGrid.remove(this.saveGrid.size()-1);
                }
            }
        }
    }

  /*  public Box[][] randomNumber(){
        Box choiceBox = boxLeastChoice();
        System.out.println(choiceBox.line + " " + choiceBox.column);
        int random;
        if(this.saveGridBeforeRandom.isEmpty()){
            // Create first grid backup
            this.saveGridBeforeRandom.add(new SaveChoice(this.convertGrid(this.getSudokuGrid()),choiceBox));
            random = choiceBox.getNumberPossibleNumbers(0);
            System.out.println(random);
            this.SudokuGrid[choiceBox.line][choiceBox.column].changeBox(random);
            return this.SudokuGrid;
        }
        else{
            if(choiceBox.getSizePossibleNumbers() == 2){
                //Create grid backups continuer avec nouvelle sauvgarde
                this.saveGridBeforeRandom.add(new SaveChoice(this.convertGrid(this.getSudokuGrid()),choiceBox));
                random = choiceBox.getNumberPossibleNumbers(0);
                System.out.println(random);
                this.SudokuGrid[choiceBox.line][choiceBox.column].changeBox(random);
                return this.SudokuGrid;
            }
            else{
                //Revenir sauvgarde d'avant
                System.out.println(" Revenu en arriere");
                SaveChoice save = this.saveGridBeforeRandom.get(this.saveGridBeforeRandom.size() - 1);

                this.showGrid();
                this.createSudokuGrid(save.getGrid());
                this.showGrid();
                choiceBox = save.getSelectBox();
                System.out.println(this.SudokuGrid[choiceBox.line][choiceBox.column].number);

                if(save.isChoice(save.getChoice() + 1)){
                    save.setChoice(save.getChoice() + 1);
                    System.out.println(save.getChoice() + 1);
                    random = choiceBox.getNumberPossibleNumbers(save.getChoice());
                    System.out.println(random);

                    this.SudokuGrid[choiceBox.line][choiceBox.column] = choiceBox;
                    this.SudokuGrid[choiceBox.line][choiceBox.column].changeBox(random);
                    return this.SudokuGrid;
                }
                else{
                    this.saveGridBeforeRandom.remove(this.saveGridBeforeRandom.size() - 1);
                    this.createSudokuGrid(this.saveGridBeforeRandom.get(this.saveGridBeforeRandom.size() - 1).getGrid());
                    return this.SudokuGrid;
                }

            }
        }
    }*/

    public Box boxLeastChoice(){
        boolean passInLoop = false;
        Box myBox = this.SudokuGrid[0][0];
        for(int i=0; i < SUDOKU_SIZE; i++) {
            for (int j = 0; j < SUDOKU_SIZE; j++) {
                if(!(this.SudokuGrid[i][j].valid)){
                    if(!passInLoop){
                        myBox = this.SudokuGrid[i][j];
                        passInLoop = true;
                    }
                    if(myBox.possibleNumbers.size() > this.SudokuGrid[i][j].possibleNumbers.size())
                        myBox = this.SudokuGrid[i][j];
                }
            }
        }
        return myBox;
    }

    public Box[][] getSudokuGrid(){
        return this.SudokuGrid;
    }

}

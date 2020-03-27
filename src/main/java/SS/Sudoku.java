package main.java.SS;

import java.util.ArrayList;

public class Sudoku {
    public ArrayList<Case> matrice;
    public ArrayList<Line> lineList;
    public ArrayList<Column> columnList;
    public ArrayList<Square> squareList;
    public Sudoku(int[][] board){
        //initialisation
        initMatrice();
        initLine(9);
        initColumn(9);
        //chargement matrice
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                this.matrice.add(new Case(board[i][j], j, i));
            }
        }

    }
    public void initMatrice(){
        this.matrice = new ArrayList<Case>();
    }
    public void initLine(int nb){
        this.lineList = new ArrayList<Line>();
        for(int i = 0; i < nb; i++){
            this.lineList.add(new Line());
        }
    }
    public void addLine(Line line){
        this.lineList.add(line);
    }
    public void initColumn(int nb){
        this.columnList = new ArrayList<Column>();
        for(int i = 0; i < nb; i++){
            this.columnList.add(new Column());
        }
    }
    public void addColumn(Column column){
        this.columnList.add(column);
    }
    public void initSquare(int nb){
        for(int i = 0; i < nb; i++){
            //this.squareList.add(new Line());
        }
    }
    public void addSquare(Square square){
        this.squareList.add(square);
    }

    public void printMatrice(){
        this.matrice.stream().forEach(i->{
            System.out.println("value = "+i.value);
            System.out.println("x = "+i.x);
            System.out.println("y = "+i.y);
        });
    }
}

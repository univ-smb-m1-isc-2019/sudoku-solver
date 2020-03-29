package main.java.SS;

import java.util.ArrayList;

public class Sudoku {
    public ArrayList<Case> matrice;
    public ArrayList<Line> lineList;
    public ArrayList<Column> columnList;
    public ArrayList<Square> squareList;
    public Sudoku(){
    }
    public Sudoku(int[][] board){
        //initialisation
        initMatrice();
        //chargement matrice
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                this.matrice.add(new Case(board[i][j], j, i, false));
            }
        }
        //chargement ligne, colonne et carré
        this.build();
    }
    public void build(){
        initLine(9);
        initColumn(9);
        initSquare(9);
        this.matrice.stream().forEach(elt->{
            this.lineList.get(elt.getLineID()).list.add(elt);
            this.columnList.get(elt.getColumnID()).list.add(elt);
            this.squareList.get(elt.getSquareID()).list.add(elt);
        });
    }
    public boolean solve(){
        //traitement tour
        int nbtour = 0;
        int nbModif;
        boolean fini = false;
        boolean impossible = false;
        final boolean[] updated = {true};
        while(!this.solved() && nbtour < 15 && impossible){
            updated[0] = false;
            matrice.stream().forEach(elt->{
                if(elt.value == 0){
                    AvailablePossibilities availablePossibilities = this.lineList.get(elt.getLineID()).getAvailablePossibililites();
                    availablePossibilities = this.columnList.get(elt.getColumnID()).getAvailablePossibililites(availablePossibilities);
                    elt.availablePossibilities = this.squareList.get(elt.getSquareID()).getAvailablePossibililites(availablePossibilities);
                    if(elt.availablePossibilities.getAvailablePossibilitiesNB() == 1){
                        elt.value = elt.availablePossibilities.getSolution();
                        updated[0] = true;
                        //elt.printCase();
                    }else if(elt.availablePossibilities.getAvailablePossibilitiesNB() == 2){
                        elt.value = elt.availablePossibilities.getPossibility();

                        updated[0] = true;
                        //e lt.printCase();
                    }
                }
            });
            nbtour++;
        }
        System.out.println(nbtour);
        return this.solved();
    }
    public boolean solve2(){
        //traitement tour
        int nbtour = 0;
        int sauvegarde = 0;
        int sauvegardeNb = 10;
        int nbModif = 0;
        boolean impossible = false;
        final boolean[] updated = {true};
        while(nbtour < 1){
            for(int i = 0; i < matrice.size(); i++){
                matrice.get(i).availablePossibilities = getAvailablePosibilities(i);
                if(matrice.get(i).availablePossibilities.getAvailablePossibilitiesNB() == 1){
                    matrice.get(i).value = matrice.get(i).availablePossibilities.getPossibility();
                    nbModif++;
                }else if(matrice.get(i).availablePossibilities.getAvailablePossibilitiesNB() < sauvegardeNb){
                    sauvegarde = i;
                    sauvegardeNb = matrice.get(i).availablePossibilities.getAvailablePossibilitiesNB();
                }
            }
            if(nbModif == 0 && sauvegarde != 0){
                for(int i = 0; i < sauvegardeNb; i++){

                }

                System.out.println("ok");
            }
            sauvegardeNb = 10;
            sauvegarde = 0;
            nbModif = 0;
            nbtour++;
        }
        this.printSudoku();
        System.out.println(nbtour);
        return this.solved();
    }
    public AvailablePossibilities getAvailablePosibilities(int id){
        AvailablePossibilities availablePossibilities = this.lineList.get(matrice.get(id).getLineID()).getAvailablePossibililites();
        availablePossibilities = this.columnList.get(matrice.get(id).getColumnID()).getAvailablePossibililites(availablePossibilities);
        return this.squareList.get(matrice.get(id).getSquareID()).getAvailablePossibililites(availablePossibilities);
    }
    public boolean solved(){
        boolean rtr = true;
        for(Case elt : this.matrice){
            if(elt.value == 0) rtr = false;
        }
        return rtr;
    }
    public void initMatrice(){
        this.matrice = new ArrayList<Case>();
    }
    public void initLine(int nb){
        this.lineList = new ArrayList<Line>();
        for(int i = 0; i < nb; i++){
            this.lineList.add(new Line(i));
        }
    }
    public void addLine(Line line){
        this.lineList.add(line);
    }
    public void initColumn(int nb){
        this.columnList = new ArrayList<Column>();
        for(int i = 0; i < nb; i++){
            this.columnList.add(new Column(i));
        }
    }
    public void addColumn(Column column){
        this.columnList.add(column);
    }
    public void initSquare(int nb){
        this.squareList = new ArrayList<Square>();
        for(int i = 0; i < nb; i++){
            this.squareList.add(new Square());
        }
    }
    public void addSquare(Square square){
        this.squareList.add(square);
    }

    public void printMatrice(){
        this.matrice.stream().forEach(i->{
            i.printCase();
        });
    }
    public void printSudoku(){
        System.out.println("sudoku :");
        lineList.stream().forEach(line -> {
            line.list.stream().forEach(elt->{
                System.out.print(" "+elt.value+" ");
            });
            System.out.println("");
        });
    }
}

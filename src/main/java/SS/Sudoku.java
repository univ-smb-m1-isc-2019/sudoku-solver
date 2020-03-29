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
        boolean updated = false;
        Backtracker backtracker = new Backtracker();
        System.out.println(this.solved());
        while(!this.solved()){
            System.out.println("tours : "+nbtour);
            for(int i = 0; i < matrice.size(); i++){
                matrice.get(i).availablePossibilities = getAvailablePosibilities(i);
                if(matrice.get(i).value == 0 && matrice.get(i).availablePossibilities.getAvailablePossibilitiesNB() == 1){
                    matrice.get(i).availablePossibilities.printPossibilities();
                    matrice.get(i).value = matrice.get(i).availablePossibilities.getPossibility();
                    updated = true;
                    System.out.println("modification 1 case = "+i);
                    matrice.get(i).printCase();
                }else if(matrice.get(i).value == 0 && matrice.get(i).availablePossibilities.getAvailablePossibilitiesNB() < sauvegardeNb && matrice.get(i).availablePossibilities.getAvailablePossibilitiesNB() != 0){
                    sauvegarde = i;
                    sauvegardeNb = matrice.get(i).availablePossibilities.getAvailablePossibilitiesNB();
                }
            }
            if(!updated && sauvegarde != 0){
                System.out.println("modification 2 case = "+sauvegarde);
                System.out.println("nombre de possibilité = "+this.matrice.get(sauvegarde).availablePossibilities.getAvailablePossibilitiesNB());
                System.out.println("création backtrack n = "+(backtracker.getSize()+1));
                matrice.get(sauvegarde).availablePossibilities.printPossibilities();
                backtracker.add(new BacktrackerItem(this, 1, this.matrice.get(sauvegarde).availablePossibilities.getAvailablePossibilitiesNB(), sauvegarde));
                this.matrice.get(sauvegarde).value = this.matrice.get(sauvegarde).availablePossibilities.getPossibility(1);
                matrice.get(sauvegarde).printCase();
                updated = true;
            }
            if(!updated){
                System.out.println("Aucun avancement possible");
                BacktrackerItem current = backtracker.getLastAvailable();
                System.out.println("utilisation backtrack n = "+(backtracker.list.indexOf(current)+1));
                this.copyMatrice(current.sudoku);
                this.build();
                current.use();
                this.matrice.get(current.idCase).availablePossibilities = this.getAvailablePosibilities(current.idCase);
                System.out.println("current "+current.current);
                matrice.get(current.idCase).value = matrice.get(current.idCase).availablePossibilities.getPossibility(current.current);
            }
            sauvegardeNb = 10;
            sauvegarde = 0;
            updated = false;
            nbtour++;
            //a delete
            this.printSudoku();
        }

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
    public void copyMatrice(Sudoku sudoku){
        this.initMatrice();
        sudoku.matrice.stream().forEach(elt->{
            this.matrice.add(new Case(elt.value, elt.x, elt.y));
        });
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

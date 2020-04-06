package SS;

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
        this.build(9);
    }
    public void build(int nb){
        initLine(nb);
        initColumn(nb);
        initSquare(nb);
        this.matrice.stream().forEach(elt->{
            this.lineList.get(elt.getLineID()).list.add(elt);
            this.columnList.get(elt.getColumnID()).list.add(elt);
            this.squareList.get(elt.getSquareID()).list.add(elt);
        });
    }

    public boolean solve(){
        //traitement tour
        int nbtour = 0;
        int sauvegarde = 0;
        int sauvegardeNb = 10;
        boolean updated = false;
        Backtracker backtracker = new Backtracker();
        while(!this.solved()){
            for(int i = 0; i < matrice.size(); i++){
                matrice.get(i).availablePossibilities = getAvailablePosibilities(i);
                if(matrice.get(i).value == 0 && matrice.get(i).availablePossibilities.getAvailablePossibilitiesNB() == 1){
                    matrice.get(i).value = matrice.get(i).availablePossibilities.getPossibility();
                    updated = true;
                }else if(matrice.get(i).value == 0 && matrice.get(i).availablePossibilities.getAvailablePossibilitiesNB() < sauvegardeNb && matrice.get(i).availablePossibilities.getAvailablePossibilitiesNB() != 0){
                    sauvegarde = i;
                    sauvegardeNb = matrice.get(i).availablePossibilities.getAvailablePossibilitiesNB();
                }
            }
            if(!updated && sauvegarde != 0){
                backtracker.add(new BacktrackerItem(this, 1, this.matrice.get(sauvegarde).availablePossibilities.getAvailablePossibilitiesNB(), sauvegarde));
                this.matrice.get(sauvegarde).value = this.matrice.get(sauvegarde).availablePossibilities.getPossibility(1);
                updated = true;
            }
            if(!updated){
                BacktrackerItem current = backtracker.getLastAvailable();
                this.copyMatrice(current.sudoku);
                this.build(9);
                current.use();
                this.matrice.get(current.idCase).availablePossibilities = this.getAvailablePosibilities(current.idCase);
                matrice.get(current.idCase).value = matrice.get(current.idCase).availablePossibilities.getPossibility(current.current);
            }
            sauvegardeNb = 10;
            sauvegarde = 0;
            updated = false;
            nbtour++;
        }
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
    public boolean containAllNumber(Container container) {
        boolean rtr = true;
        for (int i = 1; i < 10; i++){
            if(!container.contain(i))rtr = false;
        }
        return rtr;
    }
}

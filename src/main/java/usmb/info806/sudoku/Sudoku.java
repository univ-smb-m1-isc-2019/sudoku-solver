package usmb.info806.sudoku;


import java.util.ArrayList;

public class Sudoku {
    public ArrayList<Cell> cellList;
    public ArrayList<Line> lineList;
    public ArrayList<Column> columnsList;
    public ArrayList<Square> squareList;

    public Sudoku(int[][] board) {
        cellList = new ArrayList<Cell>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                cellList.add(new Cell(board[i][j], i, j));
            }
        }
        initAll();
    }

    public void initLine(int nb) {
        lineList = new ArrayList<Line>();
        for (int i = 0; i < nb; i++) {
            lineList.add(new Line(i));
        }

    }

    public void initColumn(int nb) {
        columnsList = new ArrayList<Column>();
        for (int i = 0; i < nb; i++) {
            columnsList.add(new Column(i));
        }

    }

    public void initSquare(int nb) {
        squareList = new ArrayList<Square>();
        for (int i = 0; i < nb; i++) {
            squareList.add(new Square(i));
        }

    }

    public void initAll() {
        initLine(9);
        initColumn(9);
        initSquare(9);
        for (Cell cell : cellList) {
            lineList.get(cell.x).cellList.add(cell);
            columnsList.get(cell.y).cellList.add(cell);
            squareList.get(cell.getSquareID()).cellList.add(cell);
        }
    }

    public void solve(){
        boolean autoEnd = false;
        boolean solved = false;
        int nbTour = 0;
        while(!solved && nbTour < 15){
            for (Cell cell : cellList){
                if (cell.value == 0){
                    trySolve(new Possibility(), cell);

                }

            }
            nbTour++;
            System.out.println("tour n° " + nbTour);
        }
    }

    public void trySolve(Possibility possibility, Cell cell){
        possibility.updatePossibility(lineList.get(cell.x).cellList);
        possibility.updatePossibility(columnsList.get(cell.y).cellList);
        possibility.updatePossibility(squareList.get(cell.getSquareID()).cellList);
        if (possibility.nbPossibility() == 1){
            System.out.println("la case :" + cell.x + "," + cell.y + " est un " + possibility.getSolution());
            cell.value = possibility.getSolution();
        }
        else {
            System.out.println("la solution pour la case :" + cell.x + "," + cell.y + " n'est pas encore disponible");
            possibility.printPossibility();
        }
    }

    public void print(){
        for (Line line: lineList) {
            System.out.println("{" + line.cellList.get(0).value + ", " + line.cellList.get(1).value + ", " + line.cellList.get(2).value
                    + ", " + line.cellList.get(3).value + ", " + line.cellList.get(4).value + ", " + line.cellList.get(5).value
                    + ", " + line.cellList.get(6).value + ", " + line.cellList.get(7).value + ", " + line.cellList.get(8).value + "}");
        }
    }

}

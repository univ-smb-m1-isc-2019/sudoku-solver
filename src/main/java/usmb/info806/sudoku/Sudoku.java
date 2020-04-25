package usmb.info806.sudoku;


import java.util.ArrayList;

public class Sudoku {
    public ArrayList<Cell> cellList;
    public ArrayList<Line> lineList;
    public ArrayList<Column> columnsList;
    public ArrayList<Square> squareList;

    public Sudoku(){}

    public Sudoku(int[][] board) {
        int id= 0;
        cellList = new ArrayList<Cell>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                cellList.add(new Cell(board[i][j], i, j));
                id++;
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



    public boolean solve(){
        int nbTurn = 0;
        int save = 0;
        int saveNb = 10;
        boolean updated = false;
        BackTracker backTracker = new BackTracker();
        while(!isSolved()){
            System.out.println("----------------------------------");
            System.out.println("       Tour n° " + nbTurn + "     ");
            System.out.println("----------------------------------");
            for(int i = 0; i < cellList.size(); i++){
                cellList.get(i).possibility = getAvailablePosibilities(i);
                if(cellList.get(i).value == 0 && cellList.get(i).possibility.nbPossibility() == 1){
                    cellList.get(i).value = cellList.get(i).possibility.getSolution();
                    updated = true;
                }else if(cellList.get(i).value == 0 && cellList.get(i).possibility.nbPossibility() < saveNb && cellList.get(i).possibility.nbPossibility() != 0){
                    save = i;
                    saveNb = cellList.get(i).possibility.nbPossibility();
                }
            }
            if(!updated && save != 0){
                backTracker.add(new BackTrackerItem(this, 1, this.cellList.get(save).possibility.nbPossibility(), save));
                this.cellList.get(save).value = this.cellList.get(save).possibility.getPossibility(1);
                updated = true;
            }
            if(!updated){
                BackTrackerItem current = backTracker.getLastAvailable();
                this.changeCellList(current.sudoku);
                this.initAll();
                current.update();
                this.cellList.get(current.cellID).possibility = this.getAvailablePosibilities(current.cellID);
                cellList.get(current.cellID).value = cellList.get(current.cellID).possibility.getPossibility(current.value);
            }
            saveNb = 10;
            save = 0;
            updated = false;
            nbTurn++;
        }
        return isSolved();
    }

    public Possibility getAvailablePosibilities(int id){
        Possibility possibility = this.lineList.get(cellList.get(id).x).getAvailablePossibilility();
        possibility = this.columnsList.get(cellList.get(id).y).getAvailablePossibilility(possibility);
        return this.squareList.get(cellList.get(id).getSquareID()).getAvailablePossibilility(possibility);
    }

    public void changeCellList(Sudoku sudoku){
        cellList = new ArrayList<Cell>();
        sudoku.cellList.stream().forEach(elt->{
            this.cellList.add(new Cell(elt.value, elt.x, elt.y));
        });
    }

    public boolean isSolved(){
        boolean res = true;
        for (Cell cell : cellList) {
            if (cell.value == 0)
                res=false;
        }
        return res;
    }

    public void print(){
        for (Line line: lineList) {
            System.out.println("{" + line.cellList.get(0).value + ", " + line.cellList.get(1).value + ", " + line.cellList.get(2).value
                    + ", " + line.cellList.get(3).value + ", " + line.cellList.get(4).value + ", " + line.cellList.get(5).value
                    + ", " + line.cellList.get(6).value + ", " + line.cellList.get(7).value + ", " + line.cellList.get(8).value + "}");
        }
    }

}

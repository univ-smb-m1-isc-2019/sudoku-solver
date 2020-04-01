package usmb.info806.sudoku;


import java.util.ArrayList;

public class Sudoku {
    public ArrayList<Cell> cellList;
    public ArrayList<Line> lineList;
    public ArrayList<Column> columnsList;
    public ArrayList<Square> squareList;

    public Sudoku(int[][] board){
        cellList = new ArrayList<Cell>();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                cellList.add(new Cell(board[i][j], i, j));
            }
        }
        initAll();
    }

    public void initLine(int nb){
        lineList = new ArrayList<Line>();
        for (int i = 0; i < nb ; i++){
            lineList.add(new Line(i));
        }

    }

    public void initColumn(int nb){
        columnsList = new ArrayList<Column>();
        for (int i = 0; i < nb ; i++){
            columnsList.add(new Column(i));
        }

    }

    public void initSquare(int nb){
        squareList = new ArrayList<Square>();
        for (int i = 0; i < nb ; i++){
            squareList.add(new Square(i));
        }

    }

    public void initAll(){
        initLine(9);
        initColumn(9);
        //initSquare(9);
        for (Cell cell: cellList) {
            // On test si la case apartient a la ligne
            if (cell.x == lineList.get(cell.x).id){
                lineList.get(cell.x).cellList.add(cell);
            }
            // On test si la case apartient a la colonne
            if (cell.y == columnsList.get(cell.y).id){
                columnsList.get(cell.y).cellList.add(cell);
            }
        }



    }


}

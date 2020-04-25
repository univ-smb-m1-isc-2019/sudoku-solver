package Sudoku;

public class BacktrackerItem {
    public Sudoku sudoku;
    public int idCase;
    public int act;
    public int maximum;

    public BacktrackerItem(Sudoku sudoku, int act, int maximum, int idCase){
        this.sudoku = new Sudoku();
        this.sudoku.initMatrice();
        sudoku.matrice.stream().forEach(elt->{
            this.sudoku.matrice.add(new Case(elt.value, elt.x, elt.y));
        });
        this.idCase = idCase;
        this.act = act;
        this.maximum = maximum;
    }

    public boolean utilise(){
        if(this.act < maximum){
            this.act++;
            return true;
        }else{
            return false;
        }
    }
}

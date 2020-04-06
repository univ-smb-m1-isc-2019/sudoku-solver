package SS;

public class BacktrackerItem {
    public Sudoku sudoku;
    public int current;
    public int maximum;
    public int idCase;
    public BacktrackerItem(Sudoku sudoku, int current, int maximum, int idCase){
        this.sudoku = new Sudoku();
        this.sudoku.initMatrice();
        sudoku.matrice.stream().forEach(elt->{
            this.sudoku.matrice.add(new Case(elt.value, elt.x, elt.y));
        });
        this.current = current;
        this.maximum = maximum;
        this.idCase = idCase;
    }
    public boolean use(){
        if(this.current < maximum){
            this.current++;
            return true;
        }else{
            return false;
        }
    }
}

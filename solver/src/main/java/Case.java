public class Case {

    /**
     * Valeur de la case
     */
    private int value;

    /**
     * Contructeur de la case
     * @param value
     */
    public Case(int value){
        this.value = value;
    }

    /**
     * Recupere la valeur de l'objet case
     * @return la valeur
     */
    public int getValue(){
        return this.value;
    }

    /**
     * Attribut une nouvelle valeur à l'objet case
     * @param value
     */
    public void setValue(int value){
        this.value = value;
    }

    /**
     * Verifie si la case est vide
     * @return un booleen
     */
    public boolean isEmpty(){
        return this.value == Sudoku.EMPTY;
    }

}

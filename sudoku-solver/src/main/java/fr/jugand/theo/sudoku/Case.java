package fr.jugand.theo.sudoku;

/**
 * Classe représentant une case
 */
public class Case {
    /**
     * Valeur de la case
     */
    private int value;

    public Case(int value){
        this.value = value;
    }

    /**
     * Retourne  la valeur d'une case
     * @return Valeur de la case
     */
    public int getValue(){
        return this.value;
    }

    /**
     * Attribue une valeur à une case
     * @param value Valeur à attribuer
     */
    public void setValue(int value){
        this.value = value;
    }

    /**
     * Verifie si la case est égale à zero
     * @return Un booléen pour savoir si la case est égale à 0
     */
    public boolean isEmpty(){
        return this.value == 0;
    }
}

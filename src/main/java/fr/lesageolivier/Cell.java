package fr.lesageolivier;

public class Cell {
    /**
     * Valeur d'une case vide
     */
    public static final int EMPTY = 0;

    /**
     * Valeur de la case
     */
    private int value;

    /**
     * Constructeur
     *
     * @param value Valeur de la case
     */
    public Cell(int value) {
        this.value = value;
    }

    /**
     * Getter sur la valeur de la case
     *
     * @return La valeur de la case
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Setter sur la valeur de la case
     * @param value La nouvelle valeur de la case
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Méthode permettant de vérifier si une case est vide
     *
     * @return true si la case et vide, false sinon
     */
    public Boolean isEmpty() {
        return this.value == EMPTY;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cell) {
            Cell other = (Cell) obj;

            return this.value == other.value;
        } else {
            return false;
        }
    }
}

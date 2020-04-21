package fr.lesageolivier;

import java.util.ArrayList;

public class CellGroup {
    /**
     * List contenant toutes les cases
     */
    private ArrayList<Cell> group;

    /**
     * Constructeur
     */
    public CellGroup() {
        this.group = new ArrayList<Cell>(0);
    }

    /**
     * Méthode permettant d'ajouter une case dans le groupe
     * @param cell
     * @return
     */
    public boolean add(Cell cell) {
        return this.group.add(cell);
    }

    /**
     * Méthode permettant de savoir si une case est dans le groupe
     *
     * @param cell Case dont on veut savoir si elle est dans le groupe
     * @return true si la case est dans le groupe, false sinon
     */
    public boolean isIn(Cell cell) {
        for(Cell it: this.group) {
            if (cell.equals(it)) return true;
        }
        return false;
    }
}
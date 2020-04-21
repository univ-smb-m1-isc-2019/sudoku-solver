package fr.jugand.theo.sudoku;

import java.util.ArrayList;

/**
 * Classe représentant un groupe de case
 */
public class Container {
    /**
     * Groupe de case
     */
    public ArrayList<Cell> listCell;

    public Container(){
        this.listCell = new ArrayList<Cell>();
    }

    /**
     * Méthode permettant de rajouter une case dans la liste de case
     * @param cell Case à ajouter
     */
    public void addCell(Cell cell){
        this.listCell.add(cell);
    }

    /**
     * Méthode permettant de vérifier si un nombre est dans le container
     *
     * @param number Nombre à vérifier
     * @return Un Booléen si le nombre est dans le container
     */
    public boolean isInContainer(int number) {
        for (Cell cell : this.listCell) {
            if (cell.getValue() == number) {
                return true;
            }
        }
        return false;
    }
}

package fr.jugand.theo.sudoku;

/**
 * Classe représentant un groupe de case
 */
public class Container {
    /**
     * Groupe de case
     */
    public Cell[] listCell;

    public Container(){
        this.listCell = new Cell[Sudoku.SIZE];
    }

    /**
     * Méthode permettant de vérifier si un nombre est dans le container
     *
     * @param row Rangée à vérifier
     * @param column Colonne à vérifier
     * @param number Nombre à vérifier
     * @return Un Booléen si le nombre est dans le container
     */
    private boolean isInContainer(int row, int column, int number) {
        for (Cell cell : this.listCell) {
            if (cell.getValue() == number)
                return true;
        }
        return false;
    }
}

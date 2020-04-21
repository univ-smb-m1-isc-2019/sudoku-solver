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
}

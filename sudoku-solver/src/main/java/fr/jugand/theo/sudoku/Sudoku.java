package fr.jugand.theo.sudoku;

/**
 * Classe représentant le sudoku
 */
public class Sudoku {

    /**
     * Grille du sudoku
     */
    private Cell[][] grid;
    /**
     * Groupe de rangée
     */
    public Row[] rows;
    /**
     * Groupe de colonne
     */
    public Column[] columns;
    /**
     * Taille de la grille
     */
    public final static int SIZE = 9;
    public final static int EMPTY = 0;

    public Sudoku(int[][] grid) {
        this.grid = new Cell[SIZE][SIZE];
        this.rows = new Row[SIZE];
        this.columns = new Column[SIZE];
        for (int h = 0; h < SIZE; h++) {
            columns[h] = new Column();
        }
        for (int i = 0; i < SIZE; i++) {
            rows[i] = new Row();
            for (int j = 0; j < SIZE; j++) {
                Cell cell = new Cell(grid[i][j]);
                this.grid[i][j] = cell;
                rows[i].addCell(cell);
                columns[j].addCell(cell);
            }
        }
    }

    /**
     * Méthode permettant de vérifier si un nombre est dans une rangée
     *
     * @param row    Rangée à vérifier
     * @param number Nombre à vérifier
     * @return Un booléen qui vérifie si le nombre est dans la rangée
     */
    private boolean isInRow(int row, int number) {
        return this.rows[row].isInContainer(number);
    }

    /**
     * Méthode permettant de vérifier si un nombre est dans une colonne
     *
     * @param column Colonne à vérifier
     * @param number Nombre à vérifier
     * @return Un booléen qui vérifie si le nombre est dans la colonne
     */
    private boolean isInCol(int column, int number) {
        return this.columns[column].isInContainer(number);
    }

    /**
     * Méthode permettant de vérifier si un nombre est dans un container 3x3
     *
     * @param row    Rangée à vérifier
     * @param column Colonne à vérifier
     * @param number Nombre à vérifier
     * @return Un Booléen si le nombre est dans le container 3x3
     */
    private boolean isInContainer(int row, int column, int number) {
        int r = row - row % 3;
        int c = column - column % 3;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (this.grid[i][j].getValue() == number)
                    return true;
            }
        }
        return false;
    }

    /**
     * Méthode permettant de vérifier si un nombre peut être placé à une certaine position
     *
     * @param row    Rangée à vérifier
     * @param column Colonne à vérifier
     * @param number Nombre à vérifier
     * @return Un booléen si le nombre peut être placer à cette position
     */
    private boolean isPlaceable(int row, int column, int number) {
        return !isInRow(row, number) && !isInCol(column, number) && !isInContainer(row, column, number);
    }

    /**
     * Méthode permettant de vérifier si on peut résoudre la grille du sudoku
     *
     * @return Un booléen pour savoir si la grille est résolvable
     */
    public boolean solve() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (this.grid[row][col].isEmpty()) {
                    for (int number = 1; number <= SIZE; number++) {
                        if (isPlaceable(row, col, number)) {
                            this.grid[row][col].setValue(number);

                            if (solve()) {
                                return true;
                            } else {
                                grid[row][col].setValue(EMPTY);
                            }
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Méthode permettant de vérifier si la grille est complète (case != de 0)
     *
     * @return Un booléen indiquant si la grille est complète
     */
    public boolean isComplete() {
        boolean res = true;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j].isEmpty())
                    res = false;
            }
        }
        return res;

    }

    /**
     * Méthode permettant d'afficher la grille
     */
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" " + grid[i][j].getValue());
            }
            System.out.println();
        }
        System.out.println();
    }
}

public class Sudoku {

    /**
     * Constante de la taille de la Grille
     */
    public static final int SIZE = 9;

    /**
     * Constante d'une case vide de la grille
     */
    public static final int EMPTY = 0;


    /**
     * Grille de sudoku de la classe
     */
    private Cell[][] grid;

    /**
     * Contructeur de la classe Sudoku
     * @param grid
     */
    public Sudoku(int[][] grid){
        this.grid = new Cell[SIZE][SIZE];
        for(int i = 0 ; i < SIZE ; i++){
            for (int j = 0; j < SIZE ; j++){
                this.grid[i][j] = new Cell(grid[i][j]);
            }
        }

    }

    /**
     * Méthode vérifiant si un entier se trouve deja dans la ligne
     * @param row
     * @param number
     * @return un booléen
     */
    private boolean isInRow(int row, int number) {
        for (int i = 0; i < SIZE; i++) {
            if (this.grid[row][i].getValue() == number) {
                return true;
            }
        }
        return false;
    }

    /**
     * Méthode vérifiant si un entier se trouve deja dans la colonne
     * @param col
     * @param number
     * @return un booléen
     */
    private boolean isInCol(int col, int number) {
        for (int i = 0; i < SIZE; i++){
            if (this.grid[i][col].getValue() == number) {
                return true;
            }
        }
        return false;
    }

    /**
     * Méthode vérifiant si un entier se trouve deja dans une sous-grille de 3X3 cases
     * @param col
     * @param number
     * @return un booléen
     */
    private boolean isInSubgrid(int row, int col, int number) {
        int r = row - row % 3;
        int c = col - col % 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (this.grid[i][j].getValue() == number) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Méthode vérifiant si un entier peut etre placé à une certaine position
     * @param row
     * @param col
     * @param number
     * @return
     */
    private boolean checkPosition(int row, int col, int number) {
        return !isInRow(row, number)  &&  !isInCol(col, number)  &&  !isInSubgrid(row, col, number);
    }

    /**
     * Méthode de résolution de la grille de sudoku
     * @return
     */
    public boolean solve() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (this.grid[row][col].isEmpty()) {
                    for (int number = 1; number <= SIZE; number++) {
                        if (checkPosition(row, col, number)) {
                            this.grid[row][col].setValue(number);

                            if (solve()) {
                                return true;
                            } else {
                                this.grid[row][col].setValue(EMPTY);
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
     * Methode verifiant que la grille ne comporte plus de 0
     * @return
     */
    public boolean isComplete(){
        boolean isComplete = true;
        int i = 0;
        int j = 0;
        while(isComplete && j < SIZE){
            while(isComplete && i < SIZE){
                if(this.grid[i][j].isEmpty()){
                    isComplete = false;
                }
                i++;
            }
            j++;
        }
        return isComplete;
    }

    /**
     * Méthode d'affichage de la grille
     */
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" " + this.grid[i][j].getValue());
            }
            System.out.println();
        }
        System.out.println();
    }

}

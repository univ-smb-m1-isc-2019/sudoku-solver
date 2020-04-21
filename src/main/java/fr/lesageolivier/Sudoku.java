package fr.lesageolivier;

public class Sudoku {
    /**
     * Taille de la grille
     */
    public static final int SIZE = 9;

    /**
     * Tableau contenant le Sudoku
     */
    private Cell[][] board;

    /**
     * Tableau conentant les rangées de la grille
     */
    private CellGroup[] rows;

    /**
     * Tableau contenant les colonnes de la grille
     */
    private CellGroup[] columns;

    /**
     * Constructeur
     *
     * @param board Tableau contenant les valeur de la grille de jeu
     */
    public Sudoku(int[][] board) {
        this.board = new Cell[SIZE][];
        this.rows = new CellGroup[SIZE];
        this.columns = new CellGroup[SIZE];

        for (int i = 0; i < SIZE; ++i)  {
            this.rows[i] = new CellGroup();
            this.columns[i] = new CellGroup();
        }

        for (int i = 0; i < SIZE; ++i) {
            this.board[i] = new Cell[SIZE];

            for (int j = 0; j < SIZE; ++j) {
                Cell cell = new Cell(board[i][j]);
                this.board[i][j] = cell;
                this.rows[i].add(cell);
                this.columns[j].add(cell);
            }
        }
        this.show();
    }

    /**
     * Méthode permettant de savoir si un nombre est dans une ligne
     *
     * @param row    Le numéro de la ligne
     * @param cell La case dont on veut connaitre la présence
     * @return true si le nombre est présent dans la ligne, false sinon
     */
    private boolean isInRow(int row, Cell cell) {
        return this.rows[row].isIn(cell);
    }

    /**
     * Méthode permettant de savoir si un nombre est dans une colonne
     *
     * @param col    Le numéro de la colonne
     * @param cell La case dont on veut connaitre la présence
     * @return true si le nombre est présent dans la colonne, false sinon
     */
    private boolean isInCol(int col, Cell cell) {
        return this.columns[col].isIn(cell);
    }

    /**
     * Méthode permettant de savoir si un élément est dans un 3x3
     *
     * @param row    Ligne appartenant au 3x3
     * @param col    Colonne appartenant au 3x3
     * @param cell La case dont on veut connaitre la présence
     * @return true si le nombre est présent dans le 3x3, false sinon
     */
    private boolean isInSub3x3(int row, int col, Cell cell) {
        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (board[i][j].equals(cell))
                    return true;

        return false;
    }

    /**
     * Méthode permettant de savoir si un nombre placé dans la case désignée
     *
     * @param row    Ligne dans laquelle on veut placer le nombre
     * @param col    Colonne dans laquelle on veut placer le nombre
     * @param cell La case que l'on veut placer
     * @return true si le nombre peut être placer dans la case désignée, false sinon
     */
    private boolean canBeHere(int row, int col, Cell cell) {
        return !isInRow(row, cell) && !isInCol(col, cell) && !isInSub3x3(row, col, cell);
    }

    /**
     * Méthode permettant de résoudre la grille
     *
     * @return true si la grill est résolue, false sinon
     */
    public boolean solve() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col].isEmpty()) {
                    for (Cell cell = new Cell(1); cell.getValue() <= SIZE; cell.increment()) {
                        if (canBeHere(row, col, cell)) {
                            board[row][col] = new Cell(cell);

                            if (solve()) {
                                return true;
                            } else {
                                board[row][col].setValue(Cell.EMPTY);
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
     * Méthode permettant d'afficher la grille
     */
    public void show() {
        for (Cell[] line : this.board) {
            for (Cell cell : line) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    /**
     * Méthode permettant de réacuperer la grille une fois réolue
     *
     * @return Un tableau de int contenant la grille
     */
    public int[][] toIntArray() {
        int[][] matrix = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; ++i)
            for (int j = 0; j < SIZE; ++j)
                matrix[i][j] = this.board[i][j].getValue();

        return matrix;
    }
}

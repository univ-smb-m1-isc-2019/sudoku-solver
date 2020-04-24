public class Solver {
    Sudoku sudoku;
    boolean resolu;
    public Solver(int[][] initBoard){
        sudoku = new Sudoku(initBoard);
    }

    public void resoudre(int line, int col) {
        if (col == 9) {
            col = 0;
            line++;
        }
        if (line == 9 && col == 0) {
            if (sudokuFini()) {
                resolu = true;
                for (int i = 0; i < sudoku.board.length; i++) {
                    for (int j = 0; j < sudoku.board.length; j++) {
                        if (sudoku.board[i][j].getValeur() != 0) {
                            sudoku.sudoku_sauv[i][j].setValeur(sudoku.board[i][j].getValeur());
                        }
                    }
                }
            } else {
                System.out.println("Sudoku pas résolu!");
            }
        } else {
            boolean nums[];
            if (sudoku.board[line][col].getValeur() == 0) {
                nums = numerosPossibles(sudoku.board, line, col);
                if (nums[0]) {
                    for (int k = 1; k < 10; k++) {
                        if (nums[k]) {
                            sudoku.board[line][col].setValeur(k);
                            if (calculLigne(sudoku.board, line) <= 45 && calculColonne(sudoku.board, col) <= 45 && calculBloc(sudoku.board, line, col) <= 45) {
                                resoudre(line, col + 1);
                            }
                        }
                    }
                    sudoku.board[line][col].setValeur(0);
                }
            } else {
                resoudre(line, col + 1);
            }
        }
    }

    public boolean[] numerosPossibles(Case[][] c, int x, int y) {
        boolean[] t = new boolean[10];
        int i, j;

        for (i = 1; i < 10; i++) {
            t[i] = true;
        }

        for (i = 0; i < 9; i++) {
            // met a faux dans le tableau t, à la case qui correspond à la valeur de g[i][y] si le chiffre est sur la colonne
            if (c[i][y].getValeur() != 0) {
                if (!t[0]) t[0] = true;
                t[c[i][y].getValeur()] = false;
            }
            //met a faux dans le tableau t, à la case qui correspond à la valeur de g[i][y] si le chiffre est sur la ligne
            if (c[x][i].getValeur() != 0) {
                if (!t[0]) t[0] = true;
                t[c[x][i].getValeur()] = false;
            }
        }
        // met a faux dans le tableau t, à la case qui correspond à la valeur de g[i][y] si le chiffre est présent dans le bloc
        int v = (x / 3) * 3;
        int h = (y / 3) * 3;
        for (i = v; i < v + 3; i++) {
            for (j = h; j < h + 3; j++) {
                if (c[i][j].getValeur() != 0) {
                    if (!t[0]) t[0] = true;
                    t[c[i][j].getValeur()] = false;
                }
            }
        }
        return t;
    }

    public boolean sudokuFini() {
        for (int i = 0; i < 9; i++) {
            if (calculLigne(sudoku.board, i) != 45) return false;
            if (calculColonne(sudoku.board, i) != 45) return false;
        }
        return true;
    }

    public int calculLigne(Case[][] board, int i) {
        int res = 0;
        for (int j = 0; j < 9; j++) {
            res += board[i][j].getValeur();
        }
        return res;
    }


    public int calculColonne(Case[][] board, int j) {
        int res = 0;
        for (int i = 0; i < 9; i++) {
            res += board[i][j].getValeur();
        }
        return res;
    }


    public int calculBloc(Case[][] board, int x, int y) {
        int i, j;
        int v = x / 3 * 3;
        int h = y / 3 * 3;
        int res = 0;
        for (i = v; i < v + 3; i++) {
            for (j = h; j < h + 3; j++) {
                res += board[i][j].getValeur();
            }
        }
        return res;
    }
}

public class Sudoku {
    private boolean resolu = false;
    Case[][] board;
    int length;

    public Sudoku(int[][] sudok) {
        length = sudok.length;
        this.board = new Case[sudok.length][sudok.length];
        for (int i = 0; i < sudok.length; i++) {
            for (int j = 0; j < sudok.length; j++) {
                this.board[i][j] = new Case(sudok[i][j]);
            }
        }

    }

    public void resoudre(int line, int col) {
        if (col == 9) {
            col = 0;
            line++;
        }
        if (line == 9 && col == 0) {
            if (sudokuFini()) {
                resolu = true;
                afficherSudoku();
            }
            else{
                System.out.println("Sudoku pas résolu!");
            }
        } else {
            boolean nums[];
            if (board[line][col].getValeur() == 0) {
                nums = numerosPossibles(board, line, col);
                if (nums[0]) {
                    for (int k = 1; k < 10; k++) {
                        if (nums[k]) {
                            board[line][col].setValeur(k);
                            if (calculLigne(board, line) <= 45 && calculColonne(board, col) <= 45 && calculBloc(board, line, col) <= 45) {
                                resoudre(line, col + 1);
                            }
                        }
                    }
                    board[line][col].setValeur(0);
                }
            } else {
                resoudre(line, col + 1);
            }
        }
    }

    public boolean[] numerosPossibles(Case[][] g, int x, int y) {
        boolean[] t = new boolean[10];
        int i, j;

        for (i = 1; i < 10; i++) {
            t[i] = true;
        }

        for (i = 0; i < 9; i++) {
            // met a faux dans le tableau t, à la case qui correspond à la valeur de g[i][y] si le chiffre est sur la colonne
            if (g[i][y].getValeur() != 0) {
                if (!t[0]) t[0] = true;
                t[g[i][y].getValeur()] = false;
            }
            //met a faux dans le tableau t, à la case qui correspond à la valeur de g[i][y] si le chiffre est sur la ligne
            if (g[x][i].getValeur() != 0) {
                if (!t[0]) t[0] = true;
                t[g[x][i].getValeur()] = false;
            }
        }
        // met a faux dans le tableau t, à la case qui correspond à la valeur de g[i][y] si le chiffre est présent dans le bloc
        int v = (x / 3) * 3;
        int h = (y / 3) * 3;
        for (i = v; i < v + 3; i++) {
            for (j = h; j < h + 3; j++) {
                if (g[i][j].getValeur() != 0) {
                    if (!t[0]) t[0] = true;
                    t[g[i][j].getValeur()] = false;
                }
            }
        }
        return t;
    }

    public boolean sudokuFini() {
        for (int i = 0; i < 9; i++) {
            if (calculLigne(board, i) != 45) return false;
            if (calculColonne(board, i) != 45) return false;
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




    public int calculBloc(Case[][] grille, int x, int y) {
        int i, j;
        int v = x / 3 * 3;
        int h = y / 3 * 3;
        int res = 0;
        for (i = v; i < v + 3; i++) {
            for (j = h; j < h + 3; j++) {
                res += grille[i][j].getValeur();
            }
        }
        return res;
    }

    public void afficherSudoku() {
        if (resolu == false) {
            System.out.println("Sudoku à résoudre:");
        } else {
            System.out.println("Sudoku résolu:");
        }
        for (int i = 0; i < board.length; i++) {
            if (i % 3 == 0)
                System.out.println(" -------------------------");
            for (int j = 0; j < board[i].length; j++) {
                if (j % 3 == 0) System.out.print("| ");
                if (board[i][j].getValeur() != 0) {
                    System.out.print(board[i][j].getValeur() + " ");
                } else {
                    System.out.print("  ");
                }

            }
            System.out.println(" |");
        }
        System.out.println(" -------------------------");
    }

    public boolean numberIsInLine(int line, int number){
        for (int i = 0; i<board.length; i++) {
            if (this.board[line][i].getValeur() == number){
                return true;
            }
        }
        return false;
    }
}

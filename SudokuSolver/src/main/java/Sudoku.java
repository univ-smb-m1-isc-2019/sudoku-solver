public class Sudoku {
    private boolean resolu = false;

    public Sudoku(int[][] board) {
        afficherSudoku(board);
        resoudre(board, 0, 0);
    }

    public void resoudre(int[][] board, int line, int col) {
        if (col == 9) {
            col = 0;
            line++;
        }
        if (line == 9 && col == 0) {
            if (sudokuFini(board)) {
                resolu = true;
                afficherSudoku(board);
            }
        } else {
            if (board[line][col] == 0) {

            } else {
                resoudre(board, line, col + 1);
            }
        }
    }

    public boolean[] numerosPossibles(int[][] g, int x, int y) {
        boolean[] t = new boolean[10];
        int i, j;

        for (i = 1; i < 10; i++) {
            t[i] = true;
        }


        for (i = 0; i < 9; i++) {
            // met a faux dans le tableau t, à la case qui correspond à la valeur de g[i][y] si le chiffre est sur la colonne
            if (g[i][y] != 0) {
                if (!t[0]) t[0] = true;
                t[g[i][y]] = false;
            }
            //met a faux dans le tableau t, à la case qui correspond à la valeur de g[i][y] si le chiffre est sur la ligne
            if (g[x][i] != 0) {
                if (!t[0]) t[0] = true;
                t[g[x][i]] = false;
            }
        }

        // met a faux dans le tableau t, à la case qui correspond à la valeur de g[i][y] si le chiffre est présent dans le bloc
        int v = (x / 3) * 3;
        int h = (y / 3) * 3;
        for (i = v; i < v + 3; i++) {
            for (j = h; j < h + 3; j++) {
                if (g[i][j] != 0) {
                    if (!t[0]) t[0] = true;
                    t[g[i][j]] = false;
                }
            }
        }
        return t;
    }

    private boolean sudokuFini(int[][] board) {
        for (int i = 0; i < 9; i++) {
            if (calculLigne(board, i) != 45) return false;
            if (calculColonne(board, i) != 45) return false;
        }
        return true;
    }

    public int calculLigne(int[][] board, int i) {
        int res = 0;
        for (int j = 0; j < 9; j++) {
            res += board[i][j];
        }
        return res;
    }

    public int calculColonne(int[][] board, int j) {
        int res = 0;
        for (int i = 0; i < 9; i++) {
            res += board[i][j];
        }
        return res;
    }

    public void afficherSudoku(int[][] board) {
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
                if (board[i][j] != 0) {
                    System.out.print(board[i][j] + " ");
                } else {
                    System.out.print("  ");
                }

            }
            System.out.println(" |");
        }
        System.out.println(" -------------------------");
    }


}

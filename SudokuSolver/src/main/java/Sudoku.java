public class Sudoku {
    private boolean resolu = false;
    protected Case[][] board;
    protected Case[][] sudoku_sauv;

    public Sudoku(int[][] sudok) {
        this.board = new Case[sudok.length][sudok.length];
        this.sudoku_sauv = new Case[sudok.length][sudok.length];
        for (int i = 0; i < sudok.length; i++) {
            for (int j = 0; j < sudok.length; j++) {
                this.board[i][j] = new Case(sudok[i][j]);
                this.sudoku_sauv[i][j] = new Case(sudok[i][j]);
            }
        }

    }

    public void afficherSudoku() {
        if (resolu == false) {
            System.out.println("Sudoku à résoudre:");
        } else {
            System.out.println("Sudoku résolu:");
        }
        for (int i = 0; i < this.sudoku_sauv.length; i++) {
            if (i % 3 == 0)
                System.out.println(" -------------------------");
            for (int j = 0; j < this.sudoku_sauv.length; j++) {
                if (j % 3 == 0) System.out.print("| ");
                if (this.sudoku_sauv[i][j].getValeur() != 0) {
                    System.out.print(this.sudoku_sauv[i][j].getValeur() + " ");
                } else {
                    System.out.print("  ");
                }

            }
            System.out.println(" |");
        }
        System.out.println(" -------------------------");
    }

    //////Fonction pour les tests/////
    public boolean possedeTousLesChiffresParLigne(int x) {
        boolean[] t = new boolean[10];
        t[0] = true;
        for (int i = 1; i < 10; i++) {
            t[i] = false;
        }
        for (int y = 0; y < 9; y++) {
            t[this.sudoku_sauv[x][y].getValeur()] = true;
        }
        for (int z = 1; z < 10; z++) {
            if (t[z] == false) return false;
        }
        return true;
    }


    public boolean possedeTousLesChiffresParColonne(int y) {
        boolean[] t = new boolean[10];
        t[0] = true;
        for (int i = 1; i < 10; i++) {
            t[i] = false;
        }
        for (int x = 0; x < 9; x++) {
            t[this.sudoku_sauv[x][y].getValeur()] = true;
        }
        for (int z = 1; z < 10; z++) {
            if (t[z] == false) return false;

        }
        return true;
    }

    public boolean possedeTousLesChiffresParBloc(int x, int y) {
        boolean[] t = new boolean[10];
        t[0] = true;
        for (int i = 1; i < 10; i++) {
            t[i] = false;
        }
        int i, j;
        int v = x / 3 * 3;
        int h = y / 3 * 3;
        for (i = v; i < v + 3; i++) {
            for (j = h; j < h + 3; j++) {
                t[this.sudoku_sauv[i][j].getValeur()] = true;
            }
        }
        for (int z = 1; z < 10; z++) {
            if (t[z] == false) return false;
        }
        return true;
    }

    public boolean resolutionCorrecte() {
        for (int i = 0; i < 9; i++) {
            if (!possedeTousLesChiffresParLigne(i)) return false;
            if (!possedeTousLesChiffresParColonne(i)) return false;
        }
        return true;
    }


}

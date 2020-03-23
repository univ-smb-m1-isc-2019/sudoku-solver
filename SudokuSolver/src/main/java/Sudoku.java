public class Sudoku {
    private boolean resolu = false;

    public Sudoku(int[][] board) {
        afficherGrille(board);
        resoudre(board, 0, 0);
    }

    public void resoudre(int[][] g, int a, int b) {
        if (b == 9) {
            b = 0;
            a++;
        }
        if (a == 9 && b == 0) {
            if (test_grille(g)) {
                resolu = true;
                afficherGrille(g);
            }
        }
        //
        else {


            if (g[a][b] == 0) {
            }
            else {
                resoudre(g, a, b + 1);
            }
        }
    }
    
    public void afficherGrille(int[][] g) {
        if (resolu == false) {
            System.out.println("Sudoku à résoudre:");
        } else {
            System.out.println("Sudoku résolu:");
        }

        for (int i = 0; i < g.length; i++) {
            if (i % 3 == 0)
                System.out.println(" -------------------------");
            for (int j = 0; j < g[i].length; j++) {
                if (j % 3 == 0) System.out.print("| ");
                if (g[i][j] != 0) {
                    System.out.print(g[i][j] + " ");
                } else {
                    System.out.print("  ");
                }

            }
            System.out.println(" |");
        }
        System.out.println(" -------------------------");
    }


}

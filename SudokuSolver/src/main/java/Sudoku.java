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
            if (testSudoku(board)) {
                resolu = true;
                afficherSudoku(board);
            }
        }

        else {

            if (board[line][col] == 0) {

            }

            else {
                resoudre(board, line, col + 1);
            }
        }
    }

    private boolean testSudoku(int[][] board) {
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

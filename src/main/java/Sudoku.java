public class Sudoku {
    public Sudoku(int[][] board) {
        for (int[] i : board) {
            System.out.println("Element: " + i);
            for (int j : i) {
                System.out.println(j);

            }
        }
    }
}

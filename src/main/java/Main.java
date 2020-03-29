public class Main {
    public static void main(String[] args) {
    int[][] BOARD= {
            { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
            { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
            { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
            { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
            { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
            { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
            { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
            { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
    };

   Sudoku sudo=new Sudoku(BOARD);
        System.out.println("Sudoku grid to solve");
        sudo.displayGid();

        // we try resolution
        if (sudo.solve()) {
            System.out.println("Sudoku gird solved");
            sudo.displayGid();
        } else {
            System.out.println("Unsolvable");
        }
}
}

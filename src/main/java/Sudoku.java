import java.util.ArrayList;

public class Sudoku {
    ArrayList<Case> listeC = new ArrayList<Case>(); // Create an ArrayList object
    ArrayList<Case> ligne = new ArrayList<Case>();
    public Sudoku(int[][] board) {
        for (int[] i : board) {

            for (int j : i) {
                Case c = new Case(j);
                listeC.add(c);
                System.out.println(c.getNumber());
            }
        }
    }
}

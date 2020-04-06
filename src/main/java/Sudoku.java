import java.util.ArrayList;

public class Sudoku {
    ArrayList<Case> listeC = new ArrayList<Case>(); // Create an ArrayList object
    ArrayList<Ligne> ligne = new ArrayList<Ligne>();
    ArrayList<Colone> colone = new ArrayList<Colone>();

    public Sudoku(int[][] board) {
        for (int[] i : board) {
            Ligne l = new Ligne();
            ligne.add(l);
            for (int j : i) {

                Case c = new Case(j);
                l.add(c);
                c.setLigne(l);

                listeC.add(c);
                //System.out.println(c.getNumber());
            }
        }

        for (int i =0 ;  i < board.length; i++) {

            Colone col = new Colone();
            colone.add(col);
            for (int j =0 ;  j < board[i].length; j++) {

                Case c = listeC.get(j*board[i].length+i);
                col.add(c);
                c.setColone(col);


            }

        }


    }

}

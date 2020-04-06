import java.util.ArrayList;

public class Sudoku {
    ArrayList<Case> listeC = new ArrayList<Case>(); // Create an ArrayList object
    ArrayList<Ligne> ligne = new ArrayList<Ligne>();
    ArrayList<Colone> colone = new ArrayList<Colone>();
    ArrayList<Bloc> bloc = new ArrayList<Bloc>();

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

        for (int i =0 ;  i < board.length; i++) {
            Bloc b = new Bloc();
            bloc.add(b);
        }

        int p = 0 ;
        int max = 2;
        int min = 0;
        for (int i =0 ;  i < listeC.size(); i = i+3) {
           // System.out.println(p);

            //fonction a rendre dynamique
            bloc.get(p).add(listeC.get(i));
            bloc.get(p).add(listeC.get(i+1));
            bloc.get(p).add(listeC.get(i+2));
            p = p+1 ;


            if ( p > max){
                System.out.println(bloc.get(p-1).listeC.size());
                if (bloc.get(p-1).listeC.size() == 9){
                    min = min + 3;
                    max = max + 3;
                }else{
                    p = min;
                }

            }





        }

    }

}

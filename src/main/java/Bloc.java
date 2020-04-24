import java.util.ArrayList;

public class Bloc {
    ArrayList<Case> listeC = new ArrayList<Case>();

    public void add(Case c) {
        listeC.add(c);
    }


    public String toString() {
        String res = "";
        for (Case i:listeC){
            res =  res  + " " + i
                    + "";
        }
        return "Bloc{" +
                "listeC=" + res +
                '}' + '\n';
    }

    public boolean contains(int k) {
        boolean bool = false;
        for (Case c :
                listeC ) {
            bool = bool || c.getNumber()==k;
        }
        return bool;
    }
}
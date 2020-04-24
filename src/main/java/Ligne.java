import java.util.ArrayList;

public class Ligne {
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
        return "Ligne{" +
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

    public Integer[] getTab() {
        Integer[] res = new Integer[listeC.size()];
        for (int i =0; i< listeC.size();i++) {
            res[i] = listeC.get(i).getNumber();
        }
        return  res;
    }
}

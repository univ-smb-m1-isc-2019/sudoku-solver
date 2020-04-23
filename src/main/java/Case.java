
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Case {
    private int number;
    private Ligne ligne;
    private Colone colone;
    private Bloc bloc;
    private ArrayList<Integer> possible = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));

    public Case(int i) {
        setNumber(i);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }


    public Ligne getLigne() {
        return ligne;
    }

    public void setLigne(Ligne ligne) {
        this.ligne = ligne;
    }

    public Colone getColone() {
        return colone;
    }

    public void setColone(Colone colone) {
        this.colone = colone;
    }


    public Bloc getBloc() {
        return bloc;
    }

    public void setBloc(Bloc bloc) {
        this.bloc = bloc;
    }

    @Override
    public String toString() {

        return "{" + number + '}';
    }

    public ArrayList<Integer> getPossible() {
        return possible;
    }

    public void setPossible() {
        if (number != 0) {
            possible.clear();
        }else{
            //System.out.println(ligne.listeC);

            //System.out.println(possible);

            for (Case i : ligne.listeC){
                Object test = i.number;
                possible.remove(test);
            }
           // System.out.println(possible);
            //System.out.println(colone.listeC);


            for (Case i : colone.listeC){
                Object test = i.number;
                possible.remove(test);
            }
           // System.out.println(possible);

            //System.out.println(bloc.listeC);

            for (Case i : bloc.listeC){
                Object test = i.number;
                possible.remove(test);
            }

            //System.out.println(possible);

        }



    }

    public int tryNumber() {
        return possible.get(0);
    }
}

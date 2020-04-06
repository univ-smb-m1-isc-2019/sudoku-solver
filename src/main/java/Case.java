public class Case {
    private int number;
    private Ligne ligne;
    private Colone colone;
    private Bloc bloc;

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
}

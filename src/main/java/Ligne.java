public class Ligne {

    public int numLigne; // Numéro de la ligne allant de 0 à 9

    public Ligne(int num){
        this.numLigne=num;
    }

    public int getLigne(){
        return numLigne;
    }

    public void setLigne(int num){
        this.numLigne=num;
    }
}

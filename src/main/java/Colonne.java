public class Colonne {

    public int numColonne; // Numéro de la colonne allant de 0 à 9

    public Colonne(int num){
        this.numColonne=num;
    }

    public int getColonne(){
        return numColonne;
    }

    public void setColonne(int num){
        this.numColonne=num;
    }
}

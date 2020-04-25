package Sudoku;

import java.util.ArrayList;

public class Sudoku {
    public ArrayList<Case> matrice;
    public ArrayList<ligne> ligneList;
    public ArrayList<Colonne> colonne;
    public ArrayList<carre> carre;
    public Sudoku(){

    }
    public Sudoku(int[][] grille){
        initMatrice();
        for(int i = 0; i < grille.length; i++){
            for(int j = 0; j < grille[i].length; j++){
                this.matrice.add(new Case(grille[i][j], j, i, false));
            }
        }
        this.construct(9);
    }
    public void initMatrice(){
        this.matrice = new ArrayList<Case>();
    }
    public void initLigne(int nb){
        this.ligneList = new ArrayList<ligne>();
        for(int i = 0; i < nb; i++){
            this.ligneList.add(new ligne(i));
        }
    }

    public void initColonne(int nb){
        this.colonne = new ArrayList<Colonne>();
        for(int i = 0; i < nb; i++){
            this.colonne.add(new Colonne(i));
        }
    }

    public void initcarre(int nb){
        this.carre = new ArrayList<carre>();
        for(int i = 0; i < nb; i++){
            this.carre.add(new carre());
        }
    }
    public void construct(int nb){
        initLigne(nb);
        initColonne(nb);
        initcarre(nb);
        this.matrice.stream().forEach(elt->{
            this.ligneList.get(elt.getLigneID()).list.add(elt);
            this.colonne.get(elt.getColonneID()).list.add(elt);
            this.carre.get(elt.getcarreID()).list.add(elt);
        });
    }

    public boolean solve(){
        int sauvegarde = 0;
        int sauvegardeNb = 10;
        boolean update = false;
        Backtracker backtracker = new Backtracker();
        while(!this.trouve()){
            for(int i = 0; i < matrice.size(); i++){
                matrice.get(i).SolutionPossible = getSolutionPossible(i);
                if(matrice.get(i).value == 0 && matrice.get(i).SolutionPossible.getSolutionPossibleNB() == 1){
                    matrice.get(i).value = matrice.get(i).SolutionPossible.getPossibility();
                    update = true;
                }else if(matrice.get(i).value == 0 && matrice.get(i).SolutionPossible.getSolutionPossibleNB() < sauvegardeNb && matrice.get(i).SolutionPossible.getSolutionPossibleNB() != 0){
                    sauvegarde = i;
                    sauvegardeNb = matrice.get(i).SolutionPossible.getSolutionPossibleNB();
                }
            }
            if(!update && sauvegarde != 0){
                backtracker.add(new BacktrackerItem(this, 1, this.matrice.get(sauvegarde).SolutionPossible.getSolutionPossibleNB(), sauvegarde));
                this.matrice.get(sauvegarde).value = this.matrice.get(sauvegarde).SolutionPossible.getPossibility(1);
                update = true;
            }
            if(!update){
                BacktrackerItem act = backtracker.getderniersolve();
                this.NewMatrice(act.sudoku);
                this.construct(9);
                act.utilise();
                this.matrice.get(act.idCase).SolutionPossible = this.getSolutionPossible(act.idCase);
                matrice.get(act.idCase).value = matrice.get(act.idCase).SolutionPossible.getPossibility(act.act);
            }
            sauvegardeNb = 10;
            sauvegarde = 0;
            update = false;

        }
        return this.trouve();
    }
    public SolutionPossible getSolutionPossible(int id){
        SolutionPossible SolutionPossible = this.ligneList.get(matrice.get(id).getLigneID()).getSolutionPossible();
        SolutionPossible = this.colonne.get(matrice.get(id).getColonneID()).getSolutionPossible(SolutionPossible);
        return this.carre.get(matrice.get(id).getcarreID()).getSolutionPossible(SolutionPossible);
    }
    public boolean trouve(){
        boolean trouve = true;
        for(Case elt : this.matrice){
            if(elt.value == 0) {
                trouve = false;
            }
        }
        return trouve;
    }
    public void NewMatrice(Sudoku sudoku){
        this.initMatrice();
        sudoku.matrice.stream().forEach(elt->{
            this.matrice.add(new Case(elt.value, elt.x, elt.y));
        });
    }




    public void printSudoku(){
        System.out.println("Solution du sudoku :");
        ligneList.stream().forEach(line -> {
            line.list.stream().forEach(elt->{
                System.out.print(" "+elt.value+" ");
            });
            System.out.println("");
        });
    }
    public boolean containAllNumber(Container container) {
        boolean bool = true;
        for (int i = 1; i < 10; i++){
            if(!container.contain(i)){
                bool = false;
            }
        }
        return bool;
    }
}

package sudokuSolver;

public class Main {

    public static void main(String[] args)
    {
        Sudoku sudoku = new Sudoku(9);//Initialisation d'une grille de taille 9x9
        sudoku.initGrilleJeu1();//Initialisation d'un jeu
        sudoku.resoudre();//On resoud le jeu
    }

}

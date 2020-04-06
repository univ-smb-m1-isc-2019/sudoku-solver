package test.java.SS;

import main.java.SS.Case;
import main.java.SS.Container;
import main.java.SS.Sudoku;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SudokuTest {
    private Sudoku sudoku;
    @BeforeEach
    public void createAndSolve() {
        int[][] board = {
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 6, 0, 0, 0, 0, 0},
                {0, 7, 0, 0, 9, 0, 2, 0, 0},
                {0, 5, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 4, 5, 7, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 3, 0},
                {0, 0, 1, 0, 0, 0, 0, 6, 8},
                {0, 0, 8, 5, 0, 0, 0, 1, 0},
                {0, 9, 0, 0, 0, 0, 4, 0, 0}
        };
        sudoku = new Sudoku(board);
        sudoku.solve();
    }
    //test pour verifier que toute la grille est complète (qu'aucun chiffre ne soit = a 0)
    @Test
    public void gridIsCompleteTest() {
        assertTrue(this.gridIsComplete());
    }
    public boolean gridIsComplete(){
        return this.sudoku.solved();
    }

    //on vérifie que chaque container contient tout les chiffres (vérifiant les doublons et les cases vide en même temps)
    @Test
    public void allLineContainAllNumberTest() {
        assertTrue(allLineContainAllNumber());
    }
    public boolean allLineContainAllNumber(){
        boolean rtr = true;
        for(Container line : sudoku.lineList){
            if(!this.sudoku.containAllNumber(line))rtr = false;
        }
        return rtr;
    }

    @Test
    public void allColumnContainAllNumberTest() {
        assertTrue(allColumnContainAllNumber());
    }
    public boolean allColumnContainAllNumber(){
        boolean rtr = true;
        for(Container column : sudoku.columnList){
            if(!this.sudoku.containAllNumber(column))rtr = false;
        }
        return rtr;
    }

    @Test
    public void allSquareContainAllNumberTest() {
        assertTrue(allSquareContainAllNumber());
    }
    public boolean allSquareContainAllNumber(){
        boolean rtr = true;
        for(Container square : sudoku.squareList){
            if(!this.sudoku.containAllNumber(square))rtr = false;
        }
        return rtr;
    }
    //on vérifie tout les test précédent qui permettent d'être sur du résultat
    @Test
    public void allTest(){
        assertTrue(gridIsComplete() && allLineContainAllNumber() && allColumnContainAllNumber() && allSquareContainAllNumber());
    }

    @AfterEach
    public void printSudoku(){
        this.sudoku.printSudoku();
    }


}
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
    public void gridIsComplete() {
        assertTrue(this.sudoku.solved());
    }

    //on vient verifier que chaque container ne contient aucun chiffre en double
    @Test
    public void allContainerContainAllNumber() {
        sudoku.lineList.stream().forEach(line ->{
            assertTrue(line.);
        });
    }

    @AfterEach
    public void printSudoku(){
        this.sudoku.printSudoku();
    }


}
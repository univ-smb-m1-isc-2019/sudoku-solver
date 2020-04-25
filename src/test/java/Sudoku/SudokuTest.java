package Sudoku;
import Sudoku.Sudoku;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SudokuTest {
    private Sudoku sudoku;
    private boolean solved = false;
    @BeforeEach
    public void main() {
        if(!solved) {
            int[][] grille = {
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
            sudoku = new Sudoku(grille);
            sudoku.solve();
        }
    }
    //verifie si la grille est bien remplie
    @Test
    public void testgrillecomplete() {
        assertTrue(this.gridIsComplete());
    }
    public boolean gridIsComplete(){
        return this.sudoku.trouve();
    }

    //On verifie qu'il n'y a pas d'erreur concernant l'attribution des chiffres (aucun doublon)
    @Test
    public void testligneContain(){
        sudoku.colonne.stream().forEach(line ->{
            assertTrue(this.sudoku.containAllNumber(line));
        });
    }
    @Test
    public void testcarreContain() {
        sudoku.carre.stream().forEach(square ->{
            assertTrue(this.sudoku.containAllNumber(square));
        });
    }
    @Test
    public void testcolonneContain() {
        sudoku.colonne.stream().forEach(column ->{
            assertTrue(this.sudoku.containAllNumber(column));
        });
    }



    @AfterEach
    public void printSudoku(){
        this.sudoku.printSudoku();
    }


}
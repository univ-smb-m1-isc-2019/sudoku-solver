import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class testSolver {

    int[][] resoluble = {
            {9, 3, 4, 1, 7, 2, 6, 8, 5},
            {7, 6, 5, 8, 9, 3, 2, 4, 1},
            {8, 1, 2, 6, 4, 5, 3, 9, 7},
            {4, 2, 9, 5, 8, 1, 7, 6, 3},
            {6, 5, 8, 7, 3, 9, 1, 2, 4},
            {1, 7, 3, 4, 2, 6, 8, 5, 9},
            {2, 9, 7, 3, 5, 8, 4, 1, 6},
            {5, 4, 6, 2, 1, 7, 9, 3, 8},
            {3, 8, 1, 9, 6, 4, 5, 7, 2}
    };

    int[][] pasResoluble = {
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

    @Test
    public void ToutesLesNumerosSontDansLigne() {
        Solver s = new Solver(resoluble);
        for (int i = 0; i < s.getTaille(); i++) {
            for (int j = 0; j < s.getTaille(); j++) {
                assertTrue(s.estDansLigne(i, resoluble[i][j]));
            }

        }
    }

    @Test
    public void TouteLesNumerosSontDansColonne() {
        Solver s = new Solver(resoluble);
        for (int i = 0; i < s.getTaille(); i++) {
            for (int j = 0; j < s.getTaille(); j++) {
                assertTrue(s.estDansColonne(j, resoluble[i][j]));
            }
        }
    }
}

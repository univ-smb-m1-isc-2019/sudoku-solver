import org.junit.Test;


import java.util.Arrays;

import static org.junit.Assert.*;

public class SudokuTest {
    int[][] board = {
            { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
            { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
            { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
            { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
            { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
            { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
            { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
            { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
    };
    @Test
    public void allNombreLigne() {

        Sudoku su = new Sudoku(board);

        su.reslove(0);
        Integer[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (Ligne i:
            su.ligne) {

            Integer[] tab = i.getTab();
            for (int t:
                 tab) {
                System.out.print(t);

            }
            System.out.println();

            Arrays.sort(tab);
            for (int t:
                    tab) {
                System.out.print(t);

            }

            assertArrayEquals(tab,test);

            System.out.println();

            //System.out.println(Arrays.asList( tab));

        }


    }
    @Test
    public void allNombreColone() {

        Sudoku su = new Sudoku(board);

        su.reslove(0);
        Integer[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (Colone i:
                su.colone) {

            Integer[] tab = i.getTab();
            for (int t:
                    tab) {
                System.out.print(t);

            }
            System.out.println();

            Arrays.sort(tab);
            for (int t:
                    tab) {
                System.out.print(t);

            }

            assertArrayEquals(tab,test);

            System.out.println();

            //System.out.println(Arrays.asList( tab));

        }


    }

    @Test
    public void allNombreBloc() {

        Sudoku su = new Sudoku(board);

        su.reslove(0);
        Integer[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (Bloc i:
                su.bloc) {

            Integer[] tab = i.getTab();
            for (int t:
                    tab) {
                System.out.print(t);

            }
            System.out.println();

            Arrays.sort(tab);
            for (int t:
                    tab) {
                System.out.print(t);

            }

            assertArrayEquals(tab,test);

            System.out.println();

            //System.out.println(Arrays.asList( tab));

        }


    }
}


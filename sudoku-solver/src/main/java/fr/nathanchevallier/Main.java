package fr.nathanchevallier;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
//        int[][] grid = {
//                { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
//                { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
//                { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
//                { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
//                { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
//                { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
//                { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
//                { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
//                { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
//        };

        int[][] grid = {
            { 7, 9, 4, 0, 8, 6, 3, 1, 0 },
            { 1, 0, 2, 0, 7, 3, 5, 8, 9 },
            { 0, 5, 0, 0, 9, 2, 0, 0, 0 },
            { 0, 0, 0, 7, 5, 0, 1, 2, 0 },
            { 0, 0, 7, 3, 0, 0, 0, 9, 6 },
            { 0, 4, 0, 0, 1, 0, 0, 0, 0 },
            { 4, 3, 0, 0, 0, 0, 0, 5, 1 },
            { 0, 0, 0, 9, 0, 0, 6, 0, 0 },
            { 6, 0, 1, 0, 3, 0, 0, 0, 0 }
    };


        Sudoku sudoku = new Sudoku(grid);
        sudoku.showGrid();
        System.out.println(" ");
        sudoku.solve();
        sudoku.showGrid();


//        System.out.println(" ");
//        for(int element : sudoku.SudokuGrid[2][0].possibleNumbers){
//            System.out.print(element);
//        }
//        System.out.println();
//        for(int element : sudoku.SudokuGrid[2][2].possibleNumbers){
//            System.out.print(element);
//        }
//        System.out.println();
//        for(int element : sudoku.SudokuGrid[2][6].possibleNumbers){
//            System.out.print(element);
//        }
//        System.out.println();
//        for(int element : sudoku.SudokuGrid[2][7].possibleNumbers){
//            System.out.print(element);
//        }
//        System.out.println();
//        for(int element : sudoku.SudokuGrid[2][8].possibleNumbers){
//            System.out.print(element);
//        }
//        //System.out.println(sudoku.SudokuGrid[0][1].possibleNumbers);
//
//        System.out.println(sudoku.SudokuGrid[2][6].sameListMembers(sudoku.SudokuGrid[2][8]));
    }

}

package fr.nathanchevallier;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        int[][] grid = {
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

        Sudoku sudoku = new Sudoku(grid);
        sudoku.showGrid();


        //System.out.println(sudoku.SudokuGrid[0][1].possibleNumbers);

        System.out.println(sudoku.SudokuGrid[0][0].areaLine(sudoku.SudokuGrid));
        System.out.println(sudoku.SudokuGrid[0][0].areaColumn(sudoku.SudokuGrid));
        System.out.println(sudoku.SudokuGrid[0][0].areaRegion(sudoku.SudokuGrid));
        
    }

}

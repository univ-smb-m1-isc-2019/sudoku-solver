package sudoku_solver

import sudoku_solver.grid.Grid

fun main(args: Array<String>) {
    val notCompletedGrid = Grid(arrayOf(
            arrayOf(2, 8, 3, 1, 5, 7, 6, 9, 4),
            arrayOf(1, 7, 4, 2, 6, 9, 3, 5, 8),
            arrayOf(6, 5, 0, 3, 4, 8, 2, 7, 1),
            arrayOf(4, 3, 1, 0, 7, 2, 9, 8, 6),
            arrayOf(8, 9, 7, 6, 1, 3, 5, 4, 2),
            arrayOf(5, 2, 6, 8, 9, 0, 7, 1, 3),
            arrayOf(9, 4, 0, 7, 3, 1, 8, 6, 5),
            arrayOf(7, 6, 8, 4, 2, 5, 1, 3, 9),
            arrayOf(3, 1, 5, 9, 8, 6, 4, 2, 7)
    ))
    println(notCompletedGrid.get(2, 2))
}

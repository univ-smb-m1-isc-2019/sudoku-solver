package sudoku_solver

import sudoku_solver.grid.Grid

fun main() {
    val notCompletedGrid = Grid(arrayOf(
            arrayOf(2, 8, 0, 1, 5, 7, 6, 9, 4),
            arrayOf(1, 0, 0, 2, 6, 9, 0, 5, 8),
            arrayOf(6, 0, 0, 3, 4, 0, 2, 7, 1),
            arrayOf(4, 3, 1, 0, 0, 2, 9, 8, 0),
            arrayOf(8, 9, 0, 6, 1, 0, 5, 0, 0),
            arrayOf(5, 2, 6, 0, 9, 0, 7, 0, 3),
            arrayOf(9, 4, 0, 7, 0, 1, 8, 6, 5),
            arrayOf(0, 6, 0, 4, 2, 5, 0, 3, 9),
            arrayOf(3, 1, 5, 9, 0, 6, 4, 2, 0)
    ))
    notCompletedGrid.solve()

    println(notCompletedGrid)
}

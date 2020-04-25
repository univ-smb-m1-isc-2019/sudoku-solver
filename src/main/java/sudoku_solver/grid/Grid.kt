package sudoku_solver.grid

import sudoku_solver.grid.constants.CellConstants
import sudoku_solver.grid.constants.GridConstants
import sudoku_solver.grid.squares.Square

class Grid(val grid: Array<Array<Int>>) {
    private val gridState: List<List<Square>>
    private val verifier: GridVerifier

    init {
        checkGridFormat()
        gridState = GridTranscriber.translate(grid)
        verifier = GridVerifier(gridState)
    }

    private fun checkGridFormat() {
        if (grid.size != GridConstants.NB_ROWS || grid[0].size != GridConstants.NB_COLUMNS)
            throw Error("La grille doit contenir 9 lignes et 9 colonnes!")
    }

    fun isCompleted(): Boolean {
        return verifier.isCompleted()
    }

    fun isValid(): Boolean {
        return verifier.isValid()
    }

    fun set(column: Int, line : Int, newValue: Int) {
        val squareToChange = gridState[column][line]
        squareToChange.set(newValue)
    }

    fun get(column: Int, line: Int): Int {
        return gridState[column][line].value
    }

    fun solve(): Boolean {
        for (row in 0 until GridConstants.NB_ROWS) {
            for (column in 0 until GridConstants.NB_COLUMNS) {
                val square = gridState[row][column]

                if (square.isNotSet()) {
                    val choices = verifier.getChoices(row, column)

                    for (choice in choices) {
                        square.set(choice)
                        if (solve())
                            return true
                        else {
                            // for the recursive call
                            square.set(CellConstants.EMPTY)
                        }
                    }
                }
            }
        }
        return true
    }

    override fun toString(): String {
        return "$gridState".replace("],", "],\n")
    }
}

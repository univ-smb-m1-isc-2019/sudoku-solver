package sudoku_solver.grid

import sudoku_solver.grid.constants.CellConstants

class Grid(val grid: Array<Array<Int>>) {
    private val gridState: List<List<Square>>
    private val verifier: GridVerifier

    init {
        checkGridFormat()
        gridState = GridTranscriber.translate(grid)
        verifier = GridVerifier(gridState)
    }

    private fun checkGridFormat() {
        if (grid.size != 9 || grid[0].size != 9)
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
        for (row in 0 until 9) {
            for (column in 0 until 9) {
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

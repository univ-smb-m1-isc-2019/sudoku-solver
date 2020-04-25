package sudoku_solver.grid

class Grid(grid: Array<Array<Int>>) {
    private val gridState = GridTranscriber.translate(grid)
    private val verifier = GridVerifier(gridState)

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
}

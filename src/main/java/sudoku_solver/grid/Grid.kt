package sudoku_solver.grid

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
}

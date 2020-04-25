package sudoku_solver.grid.squares

class SquareSet(private val square: Square): SquareState() {
    override fun isNotSet(): Boolean {
        return false
    }

    override fun set(newValue: Int) {
        square.value = newValue
    }

}

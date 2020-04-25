package sudoku_solver.grid

class SquareNotSet(private val square: Square): SquareState(square) {
    override fun isNotSet(): Boolean {
        return true
    }

    override fun set(newValue: Int) {
        square.value = newValue
        square.state = SquareSet(square)
    }

}

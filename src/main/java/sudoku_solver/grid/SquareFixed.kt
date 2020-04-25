package sudoku_solver.grid

class SquareFixed(private val square: Square): SquareState(square) {
    override fun isNotSet(): Boolean {
        return false
    }

    override fun set(newValue: Int) {

    }

}

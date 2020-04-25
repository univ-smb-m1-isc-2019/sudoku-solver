package sudoku_solver.grid.squares

class SquareNotSet(private val square: Square): SquareState() {
    override fun isNotSet(): Boolean {
        return true
    }

    override fun set(newValue: Int) {
        square.value = newValue
        square.state = SquareSet(square)
    }

}

package sudoku_solver

data class Square(var value: Int) {
    var state = when (value) {
        0 -> SquareNotSet(this);
        else -> SquareFixed(this)
    }

    fun isNotSet(): Boolean {
        return state.isNotSet()
    }

    fun set(newValue: Int) {
        state.set(newValue)
    }
}

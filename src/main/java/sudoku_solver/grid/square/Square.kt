package grid.square

import sudoku_solver.grid.constants.CellConstants

data class Square(var value: Int) {
    var state = when (value) {
        CellConstants.EMPTY -> SquareNotSet(this);
        else -> SquareFixed(this)
    }

    fun isNotSet(): Boolean {
        return state.isNotSet()
    }

    fun set(newValue: Int) {
        state.set(newValue)
    }

    override fun toString(): String {
        return "$value"
    }
}

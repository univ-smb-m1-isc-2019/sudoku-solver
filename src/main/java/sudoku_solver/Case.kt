package sudoku_solver

data class Case(var value: Int) {
    fun isNotSet(): Boolean {
        return value == 0
    }

    fun set(newValue: Int) {
        value = newValue
    }
}

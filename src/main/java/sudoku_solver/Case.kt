package sudoku_solver

data class Case(val value: Int) {
    fun isNotSet(): Boolean {
        return value == 0
    }
}

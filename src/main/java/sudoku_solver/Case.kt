package sudoku_solver

class Case(private val value: Int) {
    fun isNotSet(): Boolean {
        return value == 0
    }
}

package sudoku_solver

class Grid(grid: Array<Array<Int>>) {
    private val gridState = grid.map { it -> it.map { Case(it) } }

    fun isCompleted(): Boolean {
        for(line in gridState) {
            for(case in line) {
                if (case.isNotSet()) return false
            }
        }
        return true
    }

    fun isValid(): Boolean {
        return false
    }
}

package sudoku_solver

class Grid(private val grid: Array<Array<Case>>) {
    fun isCompleted(): Boolean {
        for(line in grid) {
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

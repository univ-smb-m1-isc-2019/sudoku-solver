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
        return linesAreValid() && columnsAreValid() && squaresAreValid()
    }

    private fun linesAreValid(): Boolean {
        for (actualLine in gridState) {
            if(!isValid(actualLine)) return false
        }
        return true
    }

    private fun columnsAreValid(): Boolean {
        val column: ArrayList<Case> = ArrayList()

        for (columnIndex in gridState.indices) {
            for (lineIndex in gridState.indices) {
                column.add(gridState[lineIndex][columnIndex])
            }
            if (!isValid(column)) return false
            column.clear()
        }
        return true
    }

    private fun squaresAreValid(): Boolean {
        val square: ArrayList<Case> = ArrayList()

        for (x in gridState.indices step 3) {
            for (y in gridState[x].indices step 3) {
                square.add(gridState[x][y])
                square.add(gridState[x][y+1])
                square.add(gridState[x][y+2])
            }
            if(!isValid(square)) return false
            square.clear()
        }
        return true
    }

    private fun isValid(listCases: List<Case>): Boolean {
        val buffer: ArrayList<Case> = ArrayList()

        for (case in listCases) {
            if (buffer.contains(case)) return false
            if (case.value != 0) buffer.add(case)
        }
        return true
    }
}

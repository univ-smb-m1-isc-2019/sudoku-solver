package sudoku_solver.grid

import sudoku_solver.grid.constants.CellConstants

class Grid(grid: Array<Array<Int>>) {
    private val gridState = GridTranscriber.translate(grid)

    fun isCompleted(): Boolean {
        for(line in gridState) {
            if (lineIsNotCompleted(line)) return false
        }
        return true
    }

    private fun lineIsNotCompleted(line: List<Square>): Boolean {
        for (square in line)
            if (square.isNotSet()) return true
        return false
    }

    fun isValid(): Boolean {
        return linesAreValid() && columnsAreValid() && squaresAreValid()
    }

    private fun linesAreValid(): Boolean {
        for (actualLine in gridState)
            if(!isValid(actualLine)) return false
        return true
    }

    private fun columnsAreValid(): Boolean {
        val column: ArrayList<Square> = ArrayList()

        for (columnIndex in gridState.indices) {
            for (lineIndex in gridState.indices)
                column.add(gridState[lineIndex][columnIndex])
            if (!isValid(column)) return false
            column.clear()
        }
        return true
    }

    private fun squaresAreValid(): Boolean {
        val square: ArrayList<Square> = ArrayList()

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

    private fun isValid(listSquares: List<Square>): Boolean {
        val buffer: ArrayList<Square> = ArrayList()

        for (square in listSquares) {
            if (buffer.contains(square)) return false
            if (square.value != CellConstants.EMPTY) buffer.add(square)
        }
        return true
    }

    fun set(column: Int, line : Int, newValue: Int) {
        val squareToChange = gridState[column][line];
        squareToChange.set(newValue)
    }
}

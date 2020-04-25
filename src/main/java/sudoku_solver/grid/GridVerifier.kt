package sudoku_solver.grid

import sudoku_solver.grid.constants.CellConstants
import sudoku_solver.grid.constants.GridConstants
import sudoku_solver.grid.squares.Square
import sudoku_solver.grid.squares.SquareContainer

class GridVerifier(private val gridState: List<List<Square>>) {
    private var rows = Array(GridConstants.NB_ROWS) { SquareContainer() }
    private var columns = Array(GridConstants.NB_COLUMNS) { SquareContainer() }
    private var subGrids = Array(GridConstants.NB_ROWS) { SquareContainer() }

    init {
        generateContainers()
    }

    private fun generateContainers() {
        for (row in 0 until GridConstants.NB_ROWS) {
            for (column in 0 until GridConstants.NB_COLUMNS) {
                val square = gridState[row][column]
                rows[row].add(square)
                columns[column].add(square)
                subGrids[subGridNumber(row, column)].add(square)
            }
        }
    }

    fun isCompleted(): Boolean {
        for(row in rows) {
            for (square in row) {
                if (square.isNotSet()) return false
            }
        }
        return true
    }

    fun isValid(): Boolean {
        return rowsAreValid() && columnsAreValid() && subGridsAreValid()
    }

    private fun rowsAreValid(): Boolean {
        for (actualLine in rows)
            if(!actualLine.isValid()) return false
        return true
    }

    private fun columnsAreValid(): Boolean {
        for (actualColumn in columns)
            if(!actualColumn.isValid()) return false
        return true
    }

    private fun subGridsAreValid(): Boolean {
        for (actualSubGrid in subGrids)
            if(!actualSubGrid.isValid()) return false
        return true
    }

    private fun subGridNumber(row: Int, column: Int): Int {
        return (row / 3) * 3 + column / 3
    }

    fun getChoices(row: Int, column: Int): Array<Int> {
        val rowChoices = rows[row].getChoices()
        val columnChoices = columns[column].getChoices()
        val subGridChoices = subGrids[subGridNumber(row, column)].getChoices()

        return getNotUsedValues(rowChoices, columnChoices, subGridChoices).toTypedArray()
    }

    private fun getNotUsedValues(rowChoices: Array<Int>, columnChoices: Array<Int>, subGridChoices: Array<Int>): List<Int> {
        return CellConstants.VALUES.toList()
                .minus(getUsedValues(rowChoices, columnChoices, subGridChoices))
    }

    private fun getUsedValues(rowChoices: Array<Int>, columnChoices: Array<Int>, subGridChoices: Array<Int>): Set<Int> {
        return rowChoices.union(
                columnChoices.union(
                        subGridChoices.toList()
                ).toList()
        )
    }
}
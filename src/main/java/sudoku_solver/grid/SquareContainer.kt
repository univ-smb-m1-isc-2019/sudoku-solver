package sudoku_solver.grid

import sudoku_solver.grid.constants.CellConstants

class SquareContainer: ArrayList<Square>() {
    fun isValid(): Boolean {
        val buffer = ArrayList<Square>()
        var square: Square

        for (i in 0 until size) {
            square = get(i)
            if (buffer.contains(square)) return false
            if (!square.isNotSet()) buffer.add(square)
        }
        return true
    }

    fun getChoices(): Array<Int> {
        val buffer = ArrayList<Int>()
        var square: Square

        for (i in 0 until size) {
            square = get(i)
            if (!square.isNotSet()) buffer.add(square.value)
        }

        // returns all possible values not used yet
        return CellConstants.VALUES.filter {
            value -> value in buffer
        }.toTypedArray()
    }
}
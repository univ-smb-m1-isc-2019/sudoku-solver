package sudoku_solver.grid

class SquareContainer: ArrayList<Square>() {
    fun isValid(): Boolean {
        val buffer: ArrayList<Square> = ArrayList()
        var square: Square

        for (i in 0 until size) {
            square = get(i)
            if (buffer.contains(square)) return false
            if (!square.isNotSet()) buffer.add(square)
        }
        return true
    }
}
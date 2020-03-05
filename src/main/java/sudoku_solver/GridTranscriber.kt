package sudoku_solver

class GridTranscriber() {
    companion object {
        fun translate(originGrid: Array<Array<Int>>): List<List<Square>> {
            return originGrid.map { it -> it.map { Square(it) } }
        }
    }
}

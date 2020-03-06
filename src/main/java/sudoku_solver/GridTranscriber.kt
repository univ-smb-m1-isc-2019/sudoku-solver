package sudoku_solver

class GridTranscriber() {
    companion object {
        fun translate(originGrid: Array<Array<Int>>): List<List<Square>> {
            return originGrid.map { it -> it.map { Square(it) } }
        }
        fun translate(originGrid: List<List<Square>>): Array<Array<Int>> {
            return originGrid.map { it -> it.map { it.value }.toTypedArray() }.toTypedArray()
        }
    }
}

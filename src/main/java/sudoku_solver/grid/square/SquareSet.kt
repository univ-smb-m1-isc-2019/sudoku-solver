package grid.square

class SquareSet(private val square: Square): SquareState() {
    override fun isNotSet(): Boolean {
        return false
    }

    override fun set(newValue: Int) {
        square.value = newValue
    }

}

package grid.square

class SquareFixed(private val square: Square): SquareState() {
    override fun isNotSet(): Boolean {
        return false
    }

    override fun set(newValue: Int) {

    }

}

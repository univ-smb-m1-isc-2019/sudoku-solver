package grid.square

abstract class SquareState {
    abstract fun isNotSet(): Boolean
    abstract fun set(newValue: Int)
}

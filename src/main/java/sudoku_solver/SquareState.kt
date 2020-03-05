package sudoku_solver

abstract class SquareState(square: Square) {
    abstract fun isNotSet(): Boolean
    abstract fun set(newValue: Int)
}

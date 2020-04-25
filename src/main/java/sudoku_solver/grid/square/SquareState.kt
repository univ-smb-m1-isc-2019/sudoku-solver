package sudoku_solver.grid.squares

import sudoku_solver.grid.squares.Square

abstract class SquareState(square: Square) {
    abstract fun isNotSet(): Boolean
    abstract fun set(newValue: Int)
}

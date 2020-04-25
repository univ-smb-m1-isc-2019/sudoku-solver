package sudoku_solver.grid.squares

import sudoku_solver.grid.squares.Square

abstract class SquareState {
    abstract fun isNotSet(): Boolean
    abstract fun set(newValue: Int)
}

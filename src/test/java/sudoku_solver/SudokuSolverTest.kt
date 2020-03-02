package sudoku_solver

import org.junit.Test
import kotlin.test.assertFalse

class SudokuSolverTest {
    @Test
    fun aNotCompletedGridShouldAlwaysBeConsideredAsNotCompleted() {
        val notCompletedGrid = Grid(Array(9) {Array(9) {0} })
        assertFalse { notCompletedGrid.isCompleted() }
    }
}

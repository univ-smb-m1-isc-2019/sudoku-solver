package sudoku_solver

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SudokuSolverTest {
    @Test
    fun aNotCompletedGridShouldAlwaysBeConsideredAsNotCompleted() {
        val notCompletedGrid = Grid(Array(9) {Array(9) {Case(0)} })
        assertFalse { notCompletedGrid.isCompleted() }
    }

    @Test
    fun aCompletedGridShouldAlwaysBeConsideredAsCompleted() {
        val completedGrid = Grid(arrayOf(
                arrayOf(Case(2), Case(8), Case(3), Case(1), Case(5), Case(7), Case(6), Case(9), Case(4)),
                arrayOf(Case(1), Case(7), Case(4), Case(2), Case(6), Case(9), Case(3), Case(5), Case(8)),
                arrayOf(Case(6), Case(5), Case(9), Case(3), Case(4), Case(8), Case(2), Case(7), Case(1)),
                arrayOf(Case(4), Case(3), Case(1), Case(5), Case(7), Case(2), Case(9), Case(8), Case(6)),
                arrayOf(Case(8), Case(9), Case(7), Case(6), Case(1), Case(3), Case(5), Case(4), Case(2)),
                arrayOf(Case(5), Case(2), Case(6), Case(8), Case(9), Case(4), Case(7), Case(1), Case(3)),
                arrayOf(Case(9), Case(4), Case(2), Case(7), Case(3), Case(1), Case(8), Case(6), Case(5)),
                arrayOf(Case(7), Case(6), Case(8), Case(4), Case(2), Case(5), Case(1), Case(3), Case(9)),
                arrayOf(Case(3), Case(1), Case(5), Case(9), Case(8), Case(6), Case(4), Case(2), Case(7))
        ))
        assertTrue { completedGrid.isCompleted() }
    }

    @Test
    fun anInvalidGridShouldAlwaysBeConsideredAsInvalid() {
        val invalidGrid = Grid(Array(9) {Array(9) {Case(1)} })
        assertFalse { invalidGrid.isValid() }
    }
}

package sudoku_solver

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SudokuSolverTest {
    @Test
    fun anEmptyGridShouldAlwaysBeConsideredAsNotCompleted() {
        val emptyGrid = Grid(Array(9) {Array(9) {0} })
        assertFalse { emptyGrid.isCompleted() }
    }

    @Test
    fun aNonCompletedGridShouldAlwaysBeConsideredAsCompleted() {
        val notCompletedGrid = Grid(arrayOf(
                arrayOf(2, 8, 3, 1, 5, 7, 6, 9, 4),
                arrayOf(1, 7, 4, 2, 6, 9, 3, 5, 8),
                arrayOf(6, 5, 0, 3, 4, 8, 2, 7, 1),
                arrayOf(4, 3, 1, 0, 7, 2, 9, 8, 6),
                arrayOf(8, 9, 7, 6, 1, 3, 5, 4, 2),
                arrayOf(5, 2, 6, 8, 9, 0, 7, 1, 3),
                arrayOf(9, 4, 0, 7, 3, 1, 8, 6, 5),
                arrayOf(7, 6, 8, 4, 2, 5, 1, 3, 9),
                arrayOf(3, 1, 5, 9, 8, 6, 4, 2, 7)
        ))
        assertFalse { notCompletedGrid.isCompleted() }
    }

    @Test
    fun aCompletedGridShouldAlwaysBeConsideredAsCompleted() {
        val completedGrid = Grid(arrayOf(
                arrayOf(2, 8, 3, 1, 5, 7, 6, 9, 4),
                arrayOf(1, 7, 4, 2, 6, 9, 3, 5, 8),
                arrayOf(6, 5, 9, 3, 4, 8, 2, 7, 1),
                arrayOf(4, 3, 1, 5, 7, 2, 9, 8, 6),
                arrayOf(8, 9, 7, 6, 1, 3, 5, 4, 2),
                arrayOf(5, 2, 6, 8, 9, 4, 7, 1, 3),
                arrayOf(9, 4, 2, 7, 3, 1, 8, 6, 5),
                arrayOf(7, 6, 8, 4, 2, 5, 1, 3, 9),
                arrayOf(3, 1, 5, 9, 8, 6, 4, 2, 7)
        ))
        assertTrue { completedGrid.isCompleted() }
    }

    @Test
    fun aGridOnlyWithSameValuesShouldAlwaysBeConsideredAsInvalid() {
        val invalidGrid = Grid(Array(9) {Array(9) {1} })
        assertFalse { invalidGrid.isValid() }
    }

    @Test
    fun aGridWithInvalidColumnShouldAlwaysBeConsideredAsInvalid() {
        val invalidGrid = Grid(arrayOf(
                arrayOf(2, 8, 3, 1, 5, 7, 6, 9, 4),
                arrayOf(1, 7, 4, 2, 6, 9, 3, 5, 8),
                arrayOf(6, 5, 9, 3, 4, 8, 2, 7, 1),
                arrayOf(4, 3, 1, 5, 7, 2, 9, 8, 6),
                arrayOf(8, 9, 7, 6, 1, 3, 5, 4, 2),
                arrayOf(5, 2, 6, 8, 9, 4, 7, 1, 3),
                arrayOf(9, 4, 2, 7, 3, 1, 8, 6, 5),
                arrayOf(7, 6, 8, 4, 2, 5, 1, 3, 9),
                arrayOf(2, 1, 5, 9, 8, 6, 4, 2, 7)
        ))
        assertFalse { invalidGrid.isValid() }
    }

    @Test
    fun aGridWithInvalidLineShouldAlwaysBeConsideredAsInvalid() {
        val invalidGrid = Grid(arrayOf(
                arrayOf(2, 8, 3, 1, 6, 7, 6, 9, 5),
                arrayOf(1, 7, 4, 2, 5, 9, 3, 5, 8),
                arrayOf(6, 5, 9, 3, 4, 8, 2, 7, 1),
                arrayOf(5, 3, 1, 4, 7, 2, 9, 8, 6),
                arrayOf(8, 9, 7, 6, 1, 3, 5, 4, 2),
                arrayOf(4, 2, 6, 8, 9, 5, 7, 1, 3),
                arrayOf(9, 4, 2, 7, 3, 1, 8, 6, 5),
                arrayOf(7, 6, 8, 5, 2, 4, 1, 3, 9),
                arrayOf(3, 1, 5, 9, 8, 6, 4, 2, 7)
        ))
        assertFalse { invalidGrid.isValid() }
    }

    @Test
    fun aValidGridShouldAlwaysBeConsideredAsValid() {
        val validGrid = Grid(arrayOf(
                arrayOf(2, 8, 3, 1, 5, 7, 6, 9, 4),
                arrayOf(1, 7, 4, 2, 6, 9, 3, 5, 8),
                arrayOf(6, 5, 9, 3, 4, 8, 2, 7, 1),
                arrayOf(4, 3, 1, 5, 7, 2, 9, 8, 6),
                arrayOf(8, 9, 7, 6, 1, 3, 5, 4, 2),
                arrayOf(5, 2, 6, 8, 9, 4, 7, 1, 3),
                arrayOf(9, 4, 2, 7, 3, 1, 8, 6, 5),
                arrayOf(7, 6, 8, 4, 2, 5, 1, 3, 9),
                arrayOf(3, 1, 5, 9, 8, 6, 4, 2, 7)
        ))
        assertTrue { validGrid.isValid() }
    }

    @Test
    fun anAlmostCompletedGridShouldPassToCompletedAfterItsLastCaseIsFilled() {
        val almostCompletedGrid = Grid(arrayOf(
                arrayOf(2, 8, 3, 1, 5, 7, 6, 9, 4),
                arrayOf(1, 0, 4, 2, 6, 9, 3, 5, 8),
                arrayOf(6, 5, 9, 3, 4, 8, 2, 7, 1),
                arrayOf(4, 3, 1, 5, 7, 2, 9, 8, 6),
                arrayOf(8, 9, 7, 6, 1, 3, 5, 4, 2),
                arrayOf(5, 2, 6, 8, 9, 4, 7, 1, 3),
                arrayOf(9, 4, 2, 7, 3, 1, 8, 6, 5),
                arrayOf(7, 6, 8, 4, 2, 5, 1, 3, 9),
                arrayOf(3, 1, 5, 9, 8, 6, 4, 2, 7)
        ))
        almostCompletedGrid.set(1, 1, 7)
        assertTrue { almostCompletedGrid.isCompleted() }
    }

    @Test
    fun defaultGridValuesCannotBeChanged() {
        val validGrid = Grid(arrayOf(
                arrayOf(2, 8, 3, 1, 5, 7, 6, 9, 4),
                arrayOf(1, 7, 4, 2, 6, 9, 3, 5, 8),
                arrayOf(6, 5, 9, 3, 4, 8, 2, 7, 1),
                arrayOf(4, 3, 1, 5, 7, 2, 9, 8, 6),
                arrayOf(8, 9, 7, 6, 1, 3, 5, 4, 2),
                arrayOf(5, 2, 6, 8, 9, 4, 7, 1, 3),
                arrayOf(9, 4, 2, 7, 3, 1, 8, 6, 5),
                arrayOf(7, 6, 8, 4, 2, 5, 1, 3, 9),
                arrayOf(3, 1, 5, 9, 8, 6, 4, 2, 7)
        ))
        validGrid.set(5, 5, 0)
        assertTrue { validGrid.isValid() }
    }
}

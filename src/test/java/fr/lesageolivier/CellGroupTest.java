package fr.lesageolivier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellGroupTest {
    private CellGroup group;

    @BeforeEach
    public void setUp() {
        this.group = new CellGroup();
        this.group.add(new Cell(1));
        this.group.add(new Cell(2));
        this.group.add(new Cell(3));
    }

    @Test
    public void testIsIn() {
        assertTrue(this.group.isIn(new Cell(1)));
        assertTrue(this.group.isIn(new Cell(2)));
        assertTrue(this.group.isIn(new Cell(3)));
        assertFalse(this.group.isIn(new Cell(Cell.EMPTY)));
        assertFalse(this.group.isIn(new Cell(4)));
    }
}

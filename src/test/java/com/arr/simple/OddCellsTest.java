package com.arr.simple;

import org.junit.Test;

import static org.junit.Assert.*;

public class OddCellsTest {

    OddCells obj = new OddCells();

    @Test
    public void oddCells() {
        assertEquals(6, obj.oddCells(2, 3, new int[][]{{0, 1}, {1, 1}}));
        assertEquals(0, obj.oddCells(2, 2, new int[][]{{1, 1}, {0, 0}}));
    }
}
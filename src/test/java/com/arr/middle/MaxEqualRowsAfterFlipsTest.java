package com.arr.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxEqualRowsAfterFlipsTest {

    MaxEqualRowsAfterFlips obj = new MaxEqualRowsAfterFlips();

    @Test
    public void maxEqualRowsAfterFlips() {
//        assertEquals(1, obj.maxEqualRowsAfterFlips(new int[][]{{0, 1}, {1, 1}}));
        assertEquals(2, obj.maxEqualRowsAfterFlips(new int[][]{{0, 1}, {1, 0}}));
        assertEquals(2, obj.maxEqualRowsAfterFlips(new int[][]{{0, 0, 0}, {0, 0, 1}, {1, 1, 0}}));
    }
}
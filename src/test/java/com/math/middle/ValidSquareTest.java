package com.math.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidSquareTest {

    ValidSquare obj = new ValidSquare();

    @Test
    public void validSquare() {
        assertTrue(obj.validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1}));
        assertFalse(obj.validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 12}));
        assertTrue(obj.validSquare(new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1}));
        assertFalse(obj.validSquare(new int[]{0, 0}, new int[]{0, 0}, new int[]{0, 0}, new int[]{0, 0}));
    }
}
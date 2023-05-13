package com.twopointers.simple;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindMaxKTest {

    FindMaxK obj = new FindMaxK();

    @Test
    public void findMaxK() {
        assertEquals(25, obj.findMaxK(new int[]{-25, 25, -27, 45, 31, 46, 46, 21}));
        assertEquals(3, obj.findMaxK(new int[]{-3, 3}));
        assertEquals(3, obj.findMaxK(new int[]{-1, 2, -3, 3}));
        assertEquals(7, obj.findMaxK(new int[]{-1, 10, 6, 7, -7, 1}));
        assertEquals(-1, obj.findMaxK(new int[]{-10, 8, 6, 7, -2, -3}));
    }
}
package com.greedy.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxAreaTest {

    MaxArea obj = new MaxArea();

    @Test
    public void maxArea() {
        assertEquals(81, obj.maxArea(1000000000, 1000000000, new int[]{2}, new int[]{2}));
        assertEquals(4, obj.maxArea(5, 4, new int[]{1, 2, 4}, new int[]{1, 3}));
        assertEquals(6, obj.maxArea(5, 4, new int[]{3, 1}, new int[]{1}));
        assertEquals(9, obj.maxArea(5, 4, new int[]{3}, new int[]{3}));
    }
}
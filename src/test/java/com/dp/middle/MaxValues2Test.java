package com.dp.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxValues2Test {

    MaxValues2 obj = new MaxValues2();

    @Test
    public void maxValues2() {
        assertEquals(15, obj.maxValues2(new int[]{3, 2, 1}, new int[]{5, 2, 3}, 5));
    }
}
package com.dp.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxValuesTest {

    MaxValues obj = new MaxValues();

    @Test
    public void maxValues() {
        assertEquals(8, obj.maxValues(new int[]{3, 2, 1}, new int[]{5, 2, 3}, 5));
    }
}
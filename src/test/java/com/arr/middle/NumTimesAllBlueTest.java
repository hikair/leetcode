package com.arr.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumTimesAllBlueTest {

    NumTimesAllBlue obj = new NumTimesAllBlue();

    @Test
    public void numTimesAllBlue() {
        assertEquals(2, obj.numTimesAllBlue(new int[]{3, 2, 4, 1, 5}));
        assertEquals(1, obj.numTimesAllBlue(new int[]{4, 1, 2, 3}));
    }
}
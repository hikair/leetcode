package com.arr.simple;

import org.junit.Test;

import static org.junit.Assert.*;

public class StoreWaterTest {

    StoreWater obj = new StoreWater();

    @Test
    public void storeWater() {
        assertEquals(4, obj.storeWater(new int[]{1, 3}, new int[]{6, 8}));
        assertEquals(3, obj.storeWater(new int[]{9, 0, 1}, new int[]{0, 2, 2}));
    }
}
package com.binarysearch.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumTastinessTest {

    MaximumTastiness obj = new MaximumTastiness();

    @Test
    public void maximumTastiness() {
        assertEquals(8, obj.maximumTastiness(new int[]{13, 5, 1, 8, 21, 2}, 3));
        assertEquals(2, obj.maximumTastiness(new int[]{1, 3, 1}, 2));
        assertEquals(0, obj.maximumTastiness(new int[]{7, 7, 7, 7}, 2));
    }
}
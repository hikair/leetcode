package com.hash.simple;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnequalTripletsTest {

    UnequalTriplets obj = new UnequalTriplets();

    @Test
    public void unequalTriplets() {
        assertEquals(3, obj.unequalTriplets(new int[]{4, 4, 2, 4, 3}));
        assertEquals(0, obj.unequalTriplets(new int[]{1, 1, 1, 1, 1}));
    }
}
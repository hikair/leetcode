package com.arr.simple;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestAlternatingSubarrayTest {

    LongestAlternatingSubarray obj = new LongestAlternatingSubarray();

    @Test
    public void longestAlternatingSubarray() {
        assertEquals(0, obj.longestAlternatingSubarray(new int[]{1, 10, 5}, 9));
    }
}
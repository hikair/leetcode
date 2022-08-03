package com.arr.simple;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class MinSubsequenceTest {

    MinSubsequence obj = new MinSubsequence();

    @Test
    public void minSubsequence() {
        assertEquals(Arrays.asList(10, 9), obj.minSubsequence(new int[]{4, 3, 10, 9, 8}));
        assertEquals(Arrays.asList(7, 7, 6), obj.minSubsequence(new int[]{4, 4, 7, 6, 7}));
        assertEquals(Collections.singletonList(6), obj.minSubsequence(new int[]{6}));
        assertEquals(Arrays.asList(8, 8), obj.minSubsequence(new int[]{8, 8}));
    }
}
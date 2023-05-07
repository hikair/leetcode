package com.math;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumPairsDivisibleBy60Test {

    NumPairsDivisibleBy60 obj = new NumPairsDivisibleBy60();

    @Test
    public void numPairsDivisibleBy60() {
//        assertEquals(3, obj.numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
        assertEquals(3, obj.numPairsDivisibleBy60(new int[]{60, 60, 60}));
    }
}
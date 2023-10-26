package com.num.simple;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountDigitsTest {

    CountDigits obj = new CountDigits();

    @Test
    public void countDigits() {
        assertEquals(1, obj.countDigits(7));
        assertEquals(2, obj.countDigits(121));
        assertEquals(4, obj.countDigits(1248));
    }
}
package com.math.hard;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

@Ignore
public class IsGoodArrayTest {

    IsGoodArray obj = new IsGoodArray();

    @Test
    public void gcd() {
        assertEquals(4, obj.gcd(12, 16));
        assertEquals(4, obj.gcd(16, 12));
    }
}
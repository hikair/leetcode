package com.str.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class FractionAdditionTest {

    FractionAddition obj = new FractionAddition();

    @Test
    public void fractionAddition() {
        assertEquals("0/1", obj.fractionAddition("-1/2+1/2"));
        assertEquals("1/3", obj.fractionAddition("-1/2+1/2+1/3"));
        assertEquals("-1/6", obj.fractionAddition("1/3-1/2"));
    }

    @Test
    public void gcd() {
        assertEquals(4, obj.gcd(12, 16));
    }
}
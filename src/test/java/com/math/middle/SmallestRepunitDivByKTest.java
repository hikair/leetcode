package com.math.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class SmallestRepunitDivByKTest {

    SmallestRepunitDivByK obj = new SmallestRepunitDivByK();

    @Test
    public void smallestRepunitDivByK() {
        assertEquals(1, obj.smallestRepunitDivByK(1));
        assertEquals(-1, obj.smallestRepunitDivByK(2));
        assertEquals(3, obj.smallestRepunitDivByK(3));
    }
}
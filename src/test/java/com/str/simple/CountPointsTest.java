package com.str.simple;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountPointsTest {

    CountPoints obj = new CountPoints();

    @Test
    public void countPoints() {
        assertEquals(1, obj.countPoints("B0B6G0R6R0R6G9"));
        assertEquals(1, obj.countPoints("B0R0G0R9R0B0G0"));
        assertEquals(0, obj.countPoints("G4"));
    }
}
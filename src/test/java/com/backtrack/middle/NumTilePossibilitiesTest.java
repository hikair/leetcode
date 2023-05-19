package com.backtrack.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumTilePossibilitiesTest {

    NumTilePossibilities obj = new NumTilePossibilities();

    @Test
    public void numTilePossibilities() {
        assertEquals(8, obj.numTilePossibilities("AAB"));
    }
}
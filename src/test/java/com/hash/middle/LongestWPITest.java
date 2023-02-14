package com.hash.middle;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

@Ignore
public class LongestWPITest {

    LongestWPI obj = new LongestWPI();

    @Test
    public void longestWPI() {
        assertEquals(3, obj.longestWPI(new int[]{9, 9, 6, 0, 6, 6, 9}));
        assertEquals(5, obj.longestWPI(new int[]{6, 6, 9, 9, 6, 9, 6}));
    }
}
package com.other;

import org.junit.Test;

import static org.junit.Assert.*;

public class CompareVersionTest {

    @Test
    public void compareVersion() {
        CompareVersion obj = new CompareVersion();
        assertEquals(obj.compareVersion("1", "1.1"), -1);
        assertEquals(obj.compareVersion("1.01", "1.001"), 0);
        assertEquals(obj.compareVersion("1.0", "1.0.0"), 0);
        assertEquals(obj.compareVersion("0.1", "1.1"), -1);
        assertEquals(obj.compareVersion("1.0.1", "1"), 1);
        assertEquals(obj.compareVersion("7.5.2.4", "7.5.3"), -1);
    }
}
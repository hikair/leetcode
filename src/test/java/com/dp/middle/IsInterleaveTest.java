package com.dp.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsInterleaveTest {

    IsInterleave obj = new IsInterleave();

    @Test
    public void isInterleave() {
        assertTrue(obj.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        assertFalse(obj.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        assertTrue(obj.isInterleave("", "", ""));
    }
}
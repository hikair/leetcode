package com.stack.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsValidTest {

    IsValid obj = new IsValid();

    @Test
    public void isValid() {
        assertTrue(obj.isValid("aabcbc"));
        assertTrue(obj.isValid("abcabcababcc"));
        assertFalse(obj.isValid("abccba"));
    }
}
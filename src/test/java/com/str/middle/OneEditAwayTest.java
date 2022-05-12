package com.str.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class OneEditAwayTest {

    OneEditAway obj = new OneEditAway();

    @Test
    public void oneEditAway() {
        assertTrue(obj.oneEditAway("ab", "abc"));
        assertTrue(obj.oneEditAway("abc", "ab"));
        assertTrue(obj.oneEditAway("abc", "adc"));
        assertTrue(obj.oneEditAway("abbc", "abc"));
        assertFalse(obj.oneEditAway("abdc", "ab"));
        assertFalse(obj.oneEditAway("abcc", "adc"));
    }
}
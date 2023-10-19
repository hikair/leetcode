package com.str.hard;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsMatchTest {

    IsMatch obj = new IsMatch();

    @Test
    public void isMatch() {
        assertTrue(obj.isMatch("aaa", "ab*ac*a"));
        assertTrue(obj.isMatch("ab", ".*"));
        assertFalse(obj.isMatch("abc", "abd"));
        assertTrue(obj.isMatch("abc", "a***abc"));
    }
}
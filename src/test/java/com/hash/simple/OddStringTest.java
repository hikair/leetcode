package com.hash.simple;

import org.junit.Test;

import static org.junit.Assert.*;

public class OddStringTest {

    OddString obj = new OddString();

    @Test
    public void oddString() {
        assertEquals("alm", obj.oddString(new String[]{"abm", "bcn", "alm"}));
        assertEquals("abc", obj.oddString(new String[]{"adc", "wzy", "abc"}));
        assertEquals("bob", obj.oddString(new String[]{"aaa", "bob", "ccc", "ddd"}));
    }
}
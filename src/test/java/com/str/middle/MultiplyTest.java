package com.str.middle;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

@Ignore
public class MultiplyTest {

    Multiply obj = new Multiply();

    @Test
    public void multiply() {
        assertEquals(String.valueOf(123 * 999), obj.multiply("123", "999"));
        assertEquals(String.valueOf(1000 * 100), obj.multiply("1000", "100"));
        assertEquals("891", obj.multiply("9", "99"));
        assertEquals("6", obj.multiply("2", "3"));
        assertEquals("56088", obj.multiply("123", "456"));
    }
}
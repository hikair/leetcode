package com.str;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyAtoiTest {

    @Test
    public void myAtoi() {
        MyAtoi obj = new MyAtoi();
        assertEquals(obj.myAtoi("+1"), 1);
        assertEquals(obj.myAtoi("42"), 42);
        assertEquals(obj.myAtoi(".42"), 0);
        assertEquals(obj.myAtoi("4.2"), 4);
        assertEquals(obj.myAtoi("-42"), -42);
        assertEquals(obj.myAtoi("4193 with words"), 4193);
        assertEquals(obj.myAtoi("words and 987"), 0);
        assertEquals(obj.myAtoi("-91283472332"), -2147483648);
        assertEquals(obj.myAtoi("91283472332"), 2147483647);
        assertEquals(obj.myAtoi("   91283472332"), 2147483647);
    }
}
package com.map.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyCalendarTwoTest {

    @Test
    public void book() {
        MyCalendarTwo obj = new MyCalendarTwo();
        assertTrue(obj.book(10, 20));
        assertTrue(obj.book(50, 60));
        assertTrue(obj.book(10, 40));
        assertFalse(obj.book(5, 15));
        assertTrue(obj.book(5, 10));
        assertTrue(obj.book(25, 55));
    }
}
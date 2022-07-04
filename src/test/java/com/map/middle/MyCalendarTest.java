package com.map.middle;

import org.junit.Assert;
import org.junit.Test;

public class MyCalendarTest {

    @Test
    public void book() {
        MyCalendar obj = new MyCalendar();
        Assert.assertTrue(obj.book(10, 20));
        Assert.assertFalse(obj.book(15, 25));
        Assert.assertTrue(obj.book(20, 30));
    }
}
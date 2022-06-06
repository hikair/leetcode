package com.hard;

import org.junit.Assert;
import org.junit.Test;

public class MyCalendarThreeTest {

    @Test
    public void book() {
        MyCalendarThree obj = new MyCalendarThree();
        Assert.assertEquals(1, obj.book(10, 20));
        Assert.assertEquals(1, obj.book(50, 60));
        Assert.assertEquals(2, obj.book(10, 40));
        Assert.assertEquals(3, obj.book(5, 15));
        Assert.assertEquals(3, obj.book(5, 10));
        Assert.assertEquals(3, obj.book(25, 55));
    }
}
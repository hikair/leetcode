package com.movingwindow.simple;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovingAverageTest {

    @Test
    public void next() {
        MovingAverage obj = new MovingAverage(3);
        assertEquals(1.0, obj.next(1), 0.0);
        assertEquals(5.5, obj.next(10), 0.0);
        assertEquals(4.66667, obj.next(3), 0.00001);
        assertEquals(6.0, obj.next(5), 0.0);
    }
}
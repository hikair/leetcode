package com.queue.middle.improve;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyCircularQueueTest {
    @Test
    public void queue() {
        MyCircularQueue obj = new MyCircularQueue(3);
        assertTrue(obj.enQueue(1));
        assertTrue(obj.enQueue(2));
        assertTrue(obj.enQueue(3));
        assertFalse(obj.enQueue(4));
        assertTrue(obj.deQueue());
        assertEquals(2, obj.Front());
    }
}
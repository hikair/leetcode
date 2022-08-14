package com.queue.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyCircularDequeTest {

    @Test
    public void test() {
        MyCircularDeque obj = new MyCircularDeque(3);
        assertTrue(obj.insertLast(1));
        assertTrue(obj.insertLast(2));
        assertTrue(obj.insertFront(3));
        assertFalse(obj.insertFront(4));
        assertEquals(2, obj.getRear());
        assertTrue(obj.isFull());
        assertTrue(obj.deleteLast());
        assertTrue(obj.insertFront(4));
        assertEquals(4, obj.getFront());
    }
}
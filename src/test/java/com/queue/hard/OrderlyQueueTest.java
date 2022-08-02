package com.queue.hard;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrderlyQueueTest {

    OrderlyQueue obj = new OrderlyQueue();

    @Test
    public void orderlyQueue() {
        assertEquals("acb",  obj.orderlyQueue("cba", 1));
        assertEquals("aaabc",  obj.orderlyQueue("baaca", 3));
    }
}
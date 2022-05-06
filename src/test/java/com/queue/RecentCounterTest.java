package com.queue;

import org.junit.Assert;
import org.junit.Test;

public class RecentCounterTest {

    RecentCounter obj = new RecentCounter();

    @Test
    public void ping() {
        Assert.assertEquals(1, obj.ping(1));
        Assert.assertEquals(2, obj.ping(100));
        Assert.assertEquals(3, obj.ping(3001));
        Assert.assertEquals(3, obj.ping(3002));
    }
}
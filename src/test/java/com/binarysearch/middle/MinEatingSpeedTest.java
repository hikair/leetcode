package com.binarysearch.middle;

import org.junit.Assert;
import org.junit.Test;


public class MinEatingSpeedTest {

    MinEatingSpeed obj = new MinEatingSpeed();

    @Test
    public void minEatingSpeed() {
        Assert.assertEquals(4, obj.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        Assert.assertEquals(30, obj.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        Assert.assertEquals(23, obj.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
    }
}
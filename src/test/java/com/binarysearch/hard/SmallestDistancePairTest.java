package com.binarysearch.hard;

import org.junit.Assert;
import org.junit.Test;


public class SmallestDistancePairTest {

    SmallestDistancePair obj = new SmallestDistancePair();

    @Test
    public void smallestDistancePair() {
        Assert.assertEquals(0, obj.smallestDistancePair(new int[]{1, 3, 1}, 1));
        Assert.assertEquals(0, obj.smallestDistancePair(new int[]{1, 1, 1}, 2));
        Assert.assertEquals(5, obj.smallestDistancePair(new int[]{1, 6, 1}, 3));
    }
}
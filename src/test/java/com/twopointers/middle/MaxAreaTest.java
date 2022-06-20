package com.twopointers.middle;

import org.junit.Assert;
import org.junit.Test;


public class MaxAreaTest {

    MaxArea obj = new MaxArea();

    @Test
    public void maxArea() {
        Assert.assertEquals(49, obj.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        Assert.assertEquals(1, obj.maxArea(new int[]{1, 1}));
    }
}
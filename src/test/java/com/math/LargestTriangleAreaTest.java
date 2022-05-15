package com.math;

import org.junit.Assert;
import org.junit.Test;


public class LargestTriangleAreaTest {

    LargestTriangleArea obj = new LargestTriangleArea();

    @Test
    public void largestTriangleArea() {
        Assert.assertTrue(obj.largestTriangleArea(new int[][]{{0,0},{0,1},{1,0},{0,2},{2,0}}) - 2.0 >= 0);
    }
}
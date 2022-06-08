package com.math;

import org.junit.Assert;
import org.junit.Test;


public class IsBoomerangTest {

    IsBoomerang obj = new IsBoomerang();

    @Test
    public void isBoomerang() {
        Assert.assertTrue(obj.isBoomerang(new int[][]{{1, 1}, {2, 3}, {3, 2}}));
        Assert.assertFalse(obj.isBoomerang(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
        Assert.assertTrue(obj.isBoomerang(new int[][]{{0, 0}, {0, 2}, {2, 1}}));
    }
}
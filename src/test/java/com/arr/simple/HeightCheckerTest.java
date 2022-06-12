package com.arr.simple;

import org.junit.Assert;
import org.junit.Test;


public class HeightCheckerTest {

    HeightChecker obj = new HeightChecker();

    @Test
    public void heightChecker() {
        Assert.assertEquals(3, obj.heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
        Assert.assertEquals(5, obj.heightChecker(new int[]{5, 1, 2, 3, 4}));
        Assert.assertEquals(0, obj.heightChecker(new int[]{1, 2, 3, 4, 5}));
    }
}
package com.dp;

import org.junit.Assert;
import org.junit.Test;


public class CountBitsTest {

    CountBits obj = new CountBits();

    @Test
    public void countBits4() {
        Assert.assertArrayEquals(new int[]{0, 1, 1}, obj.countBits4(2));
        Assert.assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, obj.countBits4(5));
    }

    @Test
    public void countBits3() {
        Assert.assertArrayEquals(new int[]{0, 1, 1}, obj.countBits3(2));
        Assert.assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, obj.countBits3(5));
    }

    @Test
    public void countBits2() {
        Assert.assertArrayEquals(new int[]{0, 1, 1}, obj.countBits2(2));
        Assert.assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, obj.countBits2(5));
    }
}
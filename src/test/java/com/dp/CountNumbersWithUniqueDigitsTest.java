package com.dp;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountNumbersWithUniqueDigitsTest {

    CountNumbersWithUniqueDigits obj = new CountNumbersWithUniqueDigits();

    @Test
    public void countNumbersWithUniqueDigits() {
        Assert.assertEquals(1, obj.countNumbersWithUniqueDigits(0));
        Assert.assertEquals(10, obj.countNumbersWithUniqueDigits(1));
        Assert.assertEquals(91, obj.countNumbersWithUniqueDigits(2));
    }

    @Test
    public void countNumbersWithUniqueDigits2() {
        Assert.assertEquals(1, obj.countNumbersWithUniqueDigits2(0));
        Assert.assertEquals(10, obj.countNumbersWithUniqueDigits2(1));
        Assert.assertEquals(91, obj.countNumbersWithUniqueDigits2(2));
        Assert.assertEquals(739, obj.countNumbersWithUniqueDigits2(3));
    }
}
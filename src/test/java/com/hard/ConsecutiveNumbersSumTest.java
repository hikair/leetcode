package com.hard;

import org.junit.Assert;
import org.junit.Test;


public class ConsecutiveNumbersSumTest {

    ConsecutiveNumbersSum obj = new ConsecutiveNumbersSum();

    @Test
    public void consecutiveNumbersSum() {
        Assert.assertEquals(2, obj.consecutiveNumbersSum(5));
        Assert.assertEquals(3, obj.consecutiveNumbersSum(9));
        Assert.assertEquals(4, obj.consecutiveNumbersSum(15));

    }
}
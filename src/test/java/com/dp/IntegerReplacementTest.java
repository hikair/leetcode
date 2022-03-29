package com.dp;

import org.junit.Assert;
import org.junit.Test;

public class IntegerReplacementTest {

    IntegerReplacement obj = new IntegerReplacement();

    @Test
    public void integerReplacement() {
        Assert.assertEquals(3, obj.integerReplacement(8));
        Assert.assertEquals(4, obj.integerReplacement(7));
        Assert.assertEquals(2, obj.integerReplacement(4));
        Assert.assertEquals(0, obj.integerReplacement(1));
        Assert.assertEquals(17, obj.integerReplacement(65535));
    }
}
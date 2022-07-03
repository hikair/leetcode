package com.num.middle;

import org.junit.Assert;
import org.junit.Test;

public class NextGreaterElementTest {

    NextGreaterElement obj = new NextGreaterElement();

    @Test
    public void nextGreaterElement() {
        Assert.assertEquals(21, obj.nextGreaterElement(12));
        Assert.assertEquals(-1 , obj.nextGreaterElement(21));
        Assert.assertEquals(-1 , obj.nextGreaterElement(1));
        Assert.assertEquals(2147483647 , obj.nextGreaterElement(2147483476));
        Assert.assertEquals(-1 , obj.nextGreaterElement(Integer.MAX_VALUE));
    }
}
package com.hash.simple;

import org.junit.Assert;
import org.junit.Test;


public class RepeatedNTimesTest {

    RepeatedNTimes obj = new RepeatedNTimes();

    @Test
    public void repeatedNTimes() {
        Assert.assertEquals(3, obj.repeatedNTimes(new int[]{1, 2, 3, 3}));
        Assert.assertEquals(2, obj.repeatedNTimes(new int[]{2, 1, 2, 5, 3, 2}));
        Assert.assertEquals(5, obj.repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
    }
}
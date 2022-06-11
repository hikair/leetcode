package com.dp.middle;

import org.junit.Assert;
import org.junit.Test;


public class MinFlipsMonoIncrTest {

    MinFlipsMonoIncr obj = new MinFlipsMonoIncr();

    @Test
    public void minFlipsMonoIncr() {
        Assert.assertEquals(1, obj.minFlipsMonoIncr("00110"));
        Assert.assertEquals(2, obj.minFlipsMonoIncr("010110"));
        Assert.assertEquals(2, obj.minFlipsMonoIncr("00011000"));
    }
}
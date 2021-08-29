package com.arr;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RunningSumTest extends TestCase {

    RunningSum obj;

    @Before
    public void init() {
        obj = new RunningSum();
    }

    @Test
    public void testRunningSum() {
        Assert.assertArrayEquals(obj.runningSum(new int[]{1, 2, 3, 4}), new int[]{1, 3, 6, 10});
        Assert.assertArrayEquals(obj.runningSum(new int[]{1, 1, 1, 1, 1}), new int[]{1, 2, 3, 4, 5});
        Assert.assertArrayEquals(obj.runningSum(new int[]{3, 1, 2, 10, 1}), new int[]{3, 4, 6, 16, 17});
    }
}
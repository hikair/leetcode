package com.arr.prefix;

import com.arr.prefix.SumOddLengthSubarrays;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SumOddLengthSubarraysTest extends TestCase {

    SumOddLengthSubarrays obj;

    @Before
    public void init() {
        obj = new SumOddLengthSubarrays();
    }

    @Test
    public void testSumOddLengthSubarrays() {
        Assert.assertEquals(obj.sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}), 58);
        Assert.assertEquals(obj.sumOddLengthSubarrays(new int[]{1, 2}), 3);
        Assert.assertEquals(obj.sumOddLengthSubarrays(new int[]{10, 11, 12}), 66);
    }
}
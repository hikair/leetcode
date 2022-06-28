package com.arr.middle;

import org.junit.Assert;
import org.junit.Test;

public class ThreeSumClosestTest {

    ThreeSumClosest obj = new ThreeSumClosest();

    @Test
    public void threeSumClosest() {
        Assert.assertEquals(2, obj.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        Assert.assertEquals(0, obj.threeSumClosest(new int[]{0, 0, 0}, 1));
    }
}
package com.arr.middle;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FindRadiusTest {

    FindRadius findRadius;

    @Before
    public void setUp() {
        findRadius = new FindRadius();
    }

    @Test
    public void findRadius() {
        Assert.assertEquals(1, findRadius.findRadius(new int[]{1, 2, 3}, new int[]{2}));
        Assert.assertEquals(1, findRadius.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
        Assert.assertEquals(3, findRadius.findRadius(new int[]{1, 5}, new int[]{2}));
    }
}
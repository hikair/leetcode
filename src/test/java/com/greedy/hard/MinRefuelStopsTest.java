package com.greedy.hard;

import org.junit.Assert;
import org.junit.Test;

public class MinRefuelStopsTest {

    MinRefuelStops obj = new MinRefuelStops();

    @Test
    public void minRefuelStops() {
//        Assert.assertEquals(0, obj.minRefuelStops(1, 1, new int[][]{}));
//        Assert.assertEquals(-1, obj.minRefuelStops(100, 1, new int[][]{{10, 100}}));
        Assert.assertEquals(2, obj.minRefuelStops(100, 10, new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}}));
    }
}
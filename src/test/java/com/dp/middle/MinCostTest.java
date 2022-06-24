package com.dp.middle;

import org.junit.Assert;
import org.junit.Test;


public class MinCostTest {

    MinCost obj = new MinCost();

    @Test
    public void minCost() {
        int[][] costs = new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        Assert.assertEquals(10, obj.minCost(costs));
        costs = new int[][]{{7, 6, 2}};
        Assert.assertEquals(2, obj.minCost(costs));
    }
}
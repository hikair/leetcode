package com.dp.middle;

import org.junit.Assert;
import org.junit.Test;


public class MinPathSumTest {

    MinPathSum obj = new MinPathSum();

    @Test
    public void minPathSum() {
        Assert.assertEquals(7, obj.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        Assert.assertEquals(12, obj.minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    }
}
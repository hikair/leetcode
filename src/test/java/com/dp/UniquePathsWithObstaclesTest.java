package com.dp;

import org.junit.Assert;
import org.junit.Test;

public class UniquePathsWithObstaclesTest {

    UniquePathsWithObstacles obj = new UniquePathsWithObstacles();

    @Test
    public void uniquePathsWithObstacles() {
//        Assert.assertEquals(2, obj.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
//        Assert.assertEquals(1, obj.uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
        Assert.assertEquals(3, obj.uniquePathsWithObstacles(new int[][]{{0, 1, 0}, {0, 0, 0}, {0, 0, 0}}));
    }
}
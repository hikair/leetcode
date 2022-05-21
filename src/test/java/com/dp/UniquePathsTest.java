package com.dp;

import org.junit.Assert;
import org.junit.Test;


public class UniquePathsTest {

    UniquePaths obj = new UniquePaths();

    @Test
    public void uniquePaths() {
        Assert.assertEquals(28, obj.uniquePaths(3, 7));
        Assert.assertEquals(3, obj.uniquePaths(3, 2));
    }
}
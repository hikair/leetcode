package com.arr.simple;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumWealthTest {

    MaximumWealth obj = new MaximumWealth();

    @Test
    public void maximumWealth() {
        int[][] a = {{1, 2, 3}, {3, 2, 1}};
        Assert.assertEquals(6, obj.maximumWealth(a));
        int[][] b = {{1, 5}, {7, 3}, {3, 5}};
        Assert.assertEquals(10, obj.maximumWealth(b));
        int[][] c = {{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};
        Assert.assertEquals(17, obj.maximumWealth(c));
    }
}
package com.arr.middle;

import org.junit.Assert;
import org.junit.Test;


public class MinMoves2Test {

    MinMoves2 obj = new MinMoves2();

    @Test
    public void minMoves2() {
        Assert.assertEquals(2, obj.minMoves2(new int[]{1, 2, 3}));
        Assert.assertEquals(16, obj.minMoves2(new int[]{1, 10, 2, 9}));
        Assert.assertEquals(7, obj.minMoves2(new int[]{0, 1, 2, 6}));
    }
}
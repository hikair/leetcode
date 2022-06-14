package com.arr.middle;

import org.junit.Assert;
import org.junit.Test;


public class FindDiagonalOrderTest {

    FindDiagonalOrder obj = new FindDiagonalOrder();

    @Test
    public void findDiagonalOrder() {
        Assert.assertArrayEquals(new int[]{1, 2, 4, 7, 5, 3, 6, 8, 9}, obj.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, obj.findDiagonalOrder(new int[][]{{1, 2}, {3, 4}}));
    }
}
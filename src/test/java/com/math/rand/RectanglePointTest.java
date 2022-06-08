package com.math.rand;

import org.junit.Test;


public class RectanglePointTest {


    @Test
    public void pick() {
        int[][] reces = new int[][]{{-2, -2, 1, 1}, {2, 2, 4, 6}};
        RectanglePoint obj = new RectanglePoint(reces);
        int[] pick = obj.pick();
    }
}
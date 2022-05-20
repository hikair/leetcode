package com.arr.middle;

import com.binarysearch.middle.FindRightInterval;
import org.junit.Assert;
import org.junit.Test;


public class FindRightIntervalTest {

    FindRightInterval obj = new FindRightInterval();

    @Test
    public void findRightInterval() {
        Assert.assertArrayEquals(new int[]{0, -1}, obj.findRightInterval(new int[][]{{1, 1}, {3, 4}}));
        Assert.assertArrayEquals(new int[]{-1}, obj.findRightInterval(new int[][]{{1, 2}}));
        Assert.assertArrayEquals(new int[]{-1, 0, 1}, obj.findRightInterval(new int[][]{{3, 4}, {2, 3}, {1, 2}}));
        Assert.assertArrayEquals(new int[]{-1, 2, -1}, obj.findRightInterval(new int[][]{{1, 4}, {2, 3}, {3, 4}}));
    }
}
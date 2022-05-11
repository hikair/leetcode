package com.arr.simple;

import org.junit.Assert;
import org.junit.Test;


public class MinDeletionSizeTest {

    MinDeletionSize obj = new MinDeletionSize();

    @Test
    public void minDeletionSize() {
        Assert.assertEquals(1, obj.minDeletionSize(new String[]{"abc", "bce", "cae"}));
        Assert.assertEquals(1, obj.minDeletionSize(new String[]{"cba", "daf", "ghi"}));
        Assert.assertEquals(0, obj.minDeletionSize(new String[]{"a", "b"}));
        Assert.assertEquals(3, obj.minDeletionSize(new String[]{"wvu", "zyx", "tsr"}));
    }
}
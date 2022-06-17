package com.arr.simple;

import org.junit.Assert;
import org.junit.Test;


public class DuplicateZerosTest {

    DuplicateZeros obj = new DuplicateZeros();

    @Test
    public void duplicateZeros() {
        int[] arr = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        obj.duplicateZeros(arr);
        Assert.assertArrayEquals(new int[]{1, 0, 0, 2, 3, 0, 0, 4}, arr);

        arr = new int[]{1, 2, 3};
        Assert.assertArrayEquals(new int[]{1, 2, 3}, arr);

        arr = new int[]{0, 0, 0};
        Assert.assertArrayEquals(new int[]{0, 0, 0}, arr);

    }
}
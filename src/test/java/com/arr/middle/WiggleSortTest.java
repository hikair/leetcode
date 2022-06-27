package com.arr.middle;

import org.junit.Test;

import java.util.Arrays;

public class WiggleSortTest {

    WiggleSort obj = new WiggleSort();

    @Test
    public void wiggleSort() {
        int[] n = new int[]{1, 5, 1, 1, 6, 4};
        obj.wiggleSort(n);
        System.out.println(Arrays.toString(n));
    }
}
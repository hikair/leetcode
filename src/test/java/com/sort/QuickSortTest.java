package com.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class QuickSortTest {

    @Test
    public void quickSort() {

        QuickSort obj = new QuickSort();
        int[] arr = new int[]{5, 4, 6, 9, 3, 2, 7, 1};
        obj.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
package com.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SortLogicTest {

    @Test
    public void sortArr() {
        SortLogic sortLogic = new SortLogic(new QuickSort());
        int[] arr = new int[]{5, 4, 6, 9, 3, 2, 7, 1};
        sortLogic.sortArr(arr);
        System.out.println(Arrays.toString(arr));
        sortLogic.setSortStrategy(new BubbleSort());
        arr = new int[]{3, 1, 2, 5, 7, 4, 6};
        sortLogic.sortArr(arr);
        System.out.println(Arrays.toString(arr));
        sortLogic.setSortStrategy(new SelectionSort());
        arr = new int[]{5, 4, 6, 9, 3, 2, 7, 1};
        sortLogic.sortArr(arr);
        System.out.println(Arrays.toString(arr));
    }
}
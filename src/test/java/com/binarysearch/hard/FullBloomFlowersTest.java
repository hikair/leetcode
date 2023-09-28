package com.binarysearch.hard;

import org.junit.Test;

import static org.junit.Assert.*;

public class FullBloomFlowersTest {

    FullBloomFlowers obj = new FullBloomFlowers();

    @Test
    public void fullBloomFlowers() {
        int[][] f = new int[][]{{1, 6}, {3, 7}, {9, 12}, {4, 13}};
        int[] p = new int[]{2, 3, 7, 11};
        assertArrayEquals(new int[]{1, 2, 2, 2}, obj.fullBloomFlowers(f, p));
    }

    @Test
    public void binarySearch() {
        int[] arr = new int[]{1, 3, 4, 8};
        assertEquals(1, obj.binarySearch(arr, 1));
        assertEquals(1, obj.binarySearch(arr, 2));
        assertEquals(2, obj.binarySearch(arr, 3));
        assertEquals(3, obj.binarySearch(arr, 4));
        assertEquals(3, obj.binarySearch(arr, 5));
        assertEquals(3, obj.binarySearch(arr, 6));
        assertEquals(3, obj.binarySearch(arr, 7));
        assertEquals(4, obj.binarySearch(arr, 8));
        assertEquals(4, obj.binarySearch(arr, 9));
        assertEquals(4, obj.binarySearch(arr, 11));
    }

    @Test
    public void binarySearch2() {
        int[] arr = new int[]{6, 7, 12, 13};
        assertEquals(0, obj.binarySearch(arr, 2));
        assertEquals(0, obj.binarySearch(arr, 3));
        assertEquals(1, obj.binarySearch(arr, 6));
        assertEquals(2, obj.binarySearch(arr, 7));
        assertEquals(2, obj.binarySearch(arr, 11));
        assertEquals(3, obj.binarySearch(arr, 12));
        assertEquals(4, obj.binarySearch(arr, 13));
        assertEquals(4, obj.binarySearch(arr, 14));
    }

    @Test
    public void binarySearch3() {
        int[] arr = new int[]{6, 7, 12, 13};
        System.out.println(obj.binarySearch(arr, 2)); // 0
        System.out.println(obj.binarySearch(arr, 6)); // 1
        System.out.println(obj.binarySearch(arr, 7)); // 2
        System.out.println(obj.binarySearch(arr, 11)); // 2
        System.out.println(obj.binarySearch(arr, 12)); // 3
        System.out.println(obj.binarySearch(arr, 13)); // 4
    }

    @Test
    public void binarySearch4() {
        int[] arr = new int[]{1, 3, 4, 8};
        System.out.println(obj.binarySearch(arr, 1)); // 1
        System.out.println(obj.binarySearch(arr, 2)); // 1
        System.out.println(obj.binarySearch(arr, 3)); // 2
        System.out.println(obj.binarySearch(arr, 4)); // 3
        System.out.println(obj.binarySearch(arr, 5)); // 3
        System.out.println(obj.binarySearch(arr, 6)); // 3
        System.out.println(obj.binarySearch(arr, 7)); // 3
        System.out.println(obj.binarySearch(arr, 8)); // 4
        System.out.println(obj.binarySearch(arr, 9)); // 4
    }
}
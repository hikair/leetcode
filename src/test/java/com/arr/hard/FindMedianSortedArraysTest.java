package com.arr.hard;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindMedianSortedArraysTest {

    FindMedianSortedArrays obj = new FindMedianSortedArrays();

    @Test
    public void findMedianSortedArrays() {
        System.out.println(obj.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(obj.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
package com.arr.simple;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class IntersectionTest {

    Intersection intersection;

    @Before
    public void setUp() {
        intersection = new Intersection();
    }

    @Test
    public void intersection() {
        System.out.println(Arrays.toString(intersection.intersection(new int[]{1, 2, 2, 2}, new int[]{2, 2}))); // 2
        System.out.println(Arrays.toString(intersection.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}))); // 9, 4

        System.out.println(Arrays.toString(intersection.intersection2(new int[]{1, 2, 2, 2}, new int[]{2, 2}))); // 2
        System.out.println(Arrays.toString(intersection.intersection2(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}))); // 9, 4

        System.out.println(Arrays.toString(intersection.intersection3(new int[]{1, 2, 2, 2}, new int[]{2, 2}))); // 2
        System.out.println(Arrays.toString(intersection.intersection3(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}))); // 9, 4
    }
}
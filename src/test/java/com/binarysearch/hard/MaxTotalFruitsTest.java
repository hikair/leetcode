package com.binarysearch.hard;

import org.junit.Test;

import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class MaxTotalFruitsTest {

    MaxTotalFruits obj = new MaxTotalFruits();

    @Test
    public void maxTotalFruits() {
        int[][] fruits = new int[][]{{2, 8}, {6, 3}, {8, 6}};
        assertEquals(9, obj.maxTotalFruits(fruits, 5, 4));
        fruits = new int[][]{{0, 9}, {4, 1}, {5, 7}, {6, 2}, {7, 4}, {10, 9}};
        assertEquals(14, obj.maxTotalFruits(fruits, 5, 4));
        fruits = new int[][]{{0, 3}, {6, 4}, {8, 5}};
        assertEquals(0, obj.maxTotalFruits(fruits, 3, 2));
    }
}
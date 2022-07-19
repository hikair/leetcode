package com.arr.simple;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShiftGridTest {

    ShiftGrid obj = new ShiftGrid();

    @Test
    public void shiftGrid() {
        System.out.println(obj.shiftGrid(new int[][]{{1}, {2}, {3}, {4}, {7}, {6}, {5}}, 23));
        System.out.println(obj.shiftGrid(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1));
        System.out.println(obj.shiftGrid(new int[][]{{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}}, 4));
    }
}
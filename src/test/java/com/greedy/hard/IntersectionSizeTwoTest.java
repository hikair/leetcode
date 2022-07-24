package com.greedy.hard;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntersectionSizeTwoTest {

    IntersectionSizeTwo obj = new IntersectionSizeTwo();

    @Test
    public void intersectionSizeTwo() {
        assertEquals(3, obj.intersectionSizeTwo(new int[][]{{1, 3}, {1, 4}, {2, 5}, {3, 5}}));
        assertEquals(5, obj.intersectionSizeTwo(new int[][]{{1, 2}, {2, 3}, {2, 4}, {4, 5}}));
    }
}
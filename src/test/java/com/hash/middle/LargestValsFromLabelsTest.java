package com.hash.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class LargestValsFromLabelsTest {

    LargestValsFromLabels obj = new LargestValsFromLabels();

    @Test
    public void largestValsFromLabels() {
        assertEquals(9, obj.largestValsFromLabels(new int[]{1, 4, 3, 2, 5}, new int[]{3, 1, 2, 2, 1}, 3, 1));
        assertEquals(12, obj.largestValsFromLabels(new int[]{5, 4, 3, 2, 1}, new int[]{1, 3, 3, 3, 2}, 3, 2));
        assertEquals(16, obj.largestValsFromLabels(new int[]{9, 8, 8, 7, 6}, new int[]{0, 0, 0, 1, 1}, 3, 1));
    }
}
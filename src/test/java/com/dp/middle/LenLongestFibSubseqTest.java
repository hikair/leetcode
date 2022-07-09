package com.dp.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class LenLongestFibSubseqTest {

    LenLongestFibSubseq obj = new LenLongestFibSubseq();

    @Test
    public void lenLongestFibSubseq() {
        assertEquals(5, obj.lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        assertEquals(3, obj.lenLongestFibSubseq(new int[]{1, 3, 7, 11, 12, 14, 18}));
    }
}
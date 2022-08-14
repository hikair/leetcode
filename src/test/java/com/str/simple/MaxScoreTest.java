package com.str.simple;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxScoreTest {

    MaxScore obj = new MaxScore();

    @Test
    public void maxScore() {
        assertEquals(5, obj.maxScore("011101"));
        assertEquals(5, obj.maxScore("00111"));
        assertEquals(3, obj.maxScore("1111"));
    }
}
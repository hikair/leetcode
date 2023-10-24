package com.dp.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumRollsToTargetTest {

    NumRollsToTarget obj = new NumRollsToTarget();

    @Test
    public void numRollsToTarget() {
        assertEquals(7, obj.numRollsToTarget(2, 12, 8));
        assertEquals(1, obj.numRollsToTarget(1, 6, 3));
        assertEquals(6, obj.numRollsToTarget(2, 6, 7));
        assertEquals(222616187, obj.numRollsToTarget(30, 30, 500));
        assertEquals(15, obj.numRollsToTarget(3, 6, 7));
    }
}
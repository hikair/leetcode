package com.greedy.simple;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinCostToMoveChipsTest {

    MinCostToMoveChips obj = new MinCostToMoveChips();

    @Test
    public void minCostToMoveChips() {
        assertEquals(1, obj.minCostToMoveChips(new int[]{1, 2, 3}));
        assertEquals(2, obj.minCostToMoveChips(new int[]{2, 2, 2, 3, 3}));
        assertEquals(1, obj.minCostToMoveChips(new int[]{1, 1000000000}));
    }
}
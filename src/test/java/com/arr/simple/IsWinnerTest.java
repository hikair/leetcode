package com.arr.simple;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsWinnerTest {

    IsWinner obj = new IsWinner();

    @Test
    public void isWinner() {
        assertEquals(1, obj.isWinner(new int[]{10, 2, 2, 3}, new int[]{3, 8, 4, 5}));
        assertEquals(1, obj.isWinner(new int[]{4, 10, 7, 9}, new int[]{6, 5, 2, 3}));
        assertEquals(2, obj.isWinner(new int[]{3, 5, 7, 6}, new int[]{8, 10, 10, 2}));
        assertEquals(0, obj.isWinner(new int[]{2, 3}, new int[]{4, 1}));
    }
}
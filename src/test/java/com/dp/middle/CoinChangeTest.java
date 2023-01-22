package com.dp.middle;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

@Ignore
public class CoinChangeTest {

    CoinChange obj = new CoinChange();

    @Test
    public void coinChange() {
        assertEquals(3, obj.coinChange(new int[]{1, 2, 5}, 11));
        assertEquals(-1, obj.coinChange(new int[]{2}, 3));
        assertEquals(0, obj.coinChange(new int[]{1}, 0));
    }
}
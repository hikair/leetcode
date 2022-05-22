package com.dp;

import org.junit.Assert;
import org.junit.Test;

public class CanIWinTest {

    CanIWin obj = new CanIWin();

    @Test
    public void helper() {
        Assert.assertFalse(obj.canIWin(3, 4));
        Assert.assertFalse(obj.canIWin(10, 11));
        Assert.assertTrue(obj.canIWin(10, 0));
        Assert.assertTrue(obj.canIWin(10, 1));
    }
}
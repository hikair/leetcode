package com.backtrack.middle;

import org.junit.Assert;
import org.junit.Test;


public class MakesquareTest {

    Makesquare obj = new Makesquare();

    @Test
    public void makesquare() {
        Assert.assertTrue(obj.makesquare(new int[]{1, 1, 2, 2, 2}));
        Assert.assertFalse(obj.makesquare(new int[]{3, 3, 3, 3, 4}));
    }
}
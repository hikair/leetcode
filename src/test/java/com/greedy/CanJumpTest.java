package com.greedy;

import org.junit.Assert;
import org.junit.Test;


public class CanJumpTest {

    CanJump obj = new CanJump();

    @Test
    public void canJump() {
        Assert.assertTrue(obj.canJump(new int[]{2, 3, 1, 1, 4}));
        Assert.assertFalse(obj.canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
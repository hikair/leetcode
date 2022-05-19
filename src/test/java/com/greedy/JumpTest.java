package com.greedy;

import org.junit.Assert;
import org.junit.Test;


public class JumpTest {

    Jump obj = new Jump();

    @Test
    public void jump() {
        Assert.assertEquals(2, obj.jump(new int[]{2, 3, 1, 1, 4}));
        Assert.assertEquals(3, obj.jump(new int[]{2, 3, 1, 2, 4, 2, 3}));
    }
}
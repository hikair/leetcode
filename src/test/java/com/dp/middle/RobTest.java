package com.dp.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class RobTest {

    Rob obj = new Rob();

    @Test
    public void rob() {
        assertEquals(4, obj.rob(new int[]{1, 2, 3, 1}));
        assertEquals(12, obj.rob(new int[]{2, 7, 9, 3, 1}));
    }
}
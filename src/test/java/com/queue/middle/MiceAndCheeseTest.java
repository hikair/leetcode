package com.queue.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class MiceAndCheeseTest {

    MiceAndCheese obj = new MiceAndCheese();

    @Test
    public void miceAndCheese() {
        assertEquals(15, obj.miceAndCheese(new int[]{1, 1, 3, 4}, new int[]{4, 4, 1, 1}, 2));
    }
}
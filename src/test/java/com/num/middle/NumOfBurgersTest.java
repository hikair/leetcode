package com.num.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumOfBurgersTest {

    NumOfBurgers obj = new NumOfBurgers();

    @Test
    public void numOfBurgers() {
        assertArrayEquals(new Object[]{1, 6}, obj.numOfBurgers(16, 7).toArray());
        assertArrayEquals(new Object[]{}, obj.numOfBurgers(17, 4).toArray());
        assertArrayEquals(new Object[]{}, obj.numOfBurgers(4, 17).toArray());
        assertArrayEquals(new Object[]{0, 0}, obj.numOfBurgers(0, 0).toArray());
        assertArrayEquals(new Object[]{0, 1}, obj.numOfBurgers(2, 1).toArray());
    }
}
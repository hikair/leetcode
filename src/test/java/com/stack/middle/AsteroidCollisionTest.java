package com.stack.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class AsteroidCollisionTest {

    AsteroidCollision obj = new AsteroidCollision();

    @Test
    public void asteroidCollision() {
        assertArrayEquals(new int[]{-2, -1, 1, 2}, obj.asteroidCollision(new int[]{-2, -1, 1, 2}));
        assertArrayEquals(new int[]{5, 10}, obj.asteroidCollision(new int[]{5, 10, -5}));
        assertArrayEquals(new int[]{}, obj.asteroidCollision(new int[]{8, -8}));
        assertArrayEquals(new int[]{10}, obj.asteroidCollision(new int[]{10, 2, -5}));
    }
}
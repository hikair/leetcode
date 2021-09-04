package com.arr;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class SmallestKTest {

    SmallestK obj;

    @Before
    public void init() {
        obj = new SmallestK();
    }

    @Test
    public void smallestK() {
        System.out.println(Arrays.toString(obj.smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4)));
    }

    @Test
    public void smallestK2() {
        System.out.println(Arrays.toString(obj.smallestK2(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4)));
    }

    @Test
    public void smallestK3() {
        int ridx = new Random().nextInt(10 - 1 + 1) + 1;
        System.out.println(ridx);
    }
}
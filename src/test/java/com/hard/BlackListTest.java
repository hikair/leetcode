package com.hard;

import org.junit.Test;

public class BlackListTest {

    BlackList obj = new BlackList(7, new int[]{2, 3, 5});

    @Test
    public void pick() {
        System.out.println(obj.pick());
        System.out.println(obj.pick());
        System.out.println(obj.pick());
        System.out.println(obj.pick());
        System.out.println(obj.pick());
        System.out.println(obj.pick());
    }
}
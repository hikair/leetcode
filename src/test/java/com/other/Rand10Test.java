package com.other;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Rand10Test {

    Rand10 obj;

    @Before
    public void init() {
        obj = new Rand10();
    }

    @Test
    public void rand7() {
        for (int i = 0; i < 10; i++) {
            System.out.println(obj.rand7());
        }
    }

    @Test
    public void rand10() {
        for (int i = 0; i < 100; i++) {
            System.out.println(obj.rand10());
        }
    }

    @Test
    public void rand10b() {
        for (int i = 0; i < 100; i++) {
            System.out.println(obj.rand10b());
        }
    }
}
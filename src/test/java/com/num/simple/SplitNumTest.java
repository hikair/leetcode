package com.num.simple;

import org.junit.Test;

import static org.junit.Assert.*;

public class SplitNumTest {

    SplitNum obj = new SplitNum();

    @Test
    public void splitNum() {
        assertEquals(1, obj.splitNum(10));
        assertEquals(59, obj.splitNum(4325));
        assertEquals(75, obj.splitNum(687));
    }
}
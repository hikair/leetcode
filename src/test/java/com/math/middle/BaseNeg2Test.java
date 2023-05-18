package com.math.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class BaseNeg2Test {

    BaseNeg2 obj = new BaseNeg2();

    @Test
    public void baseNeg2() {
        assertEquals("110", obj.baseNeg2(2));
        assertEquals("111", obj.baseNeg2(3));
        assertEquals("100", obj.baseNeg2(4));
    }
}
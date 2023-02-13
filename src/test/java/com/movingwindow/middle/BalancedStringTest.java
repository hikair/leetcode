package com.movingwindow.middle;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

@Ignore
public class BalancedStringTest {

    BalancedString obj = new BalancedString();

    @Test
    public void balancedString() {
        assertEquals(0, obj.balancedString("QWER"));
        assertEquals(1, obj.balancedString("QQWE"));
        assertEquals(2, obj.balancedString("QQQW"));
        assertEquals(3, obj.balancedString("QQQQ"));
        assertEquals(6, obj.balancedString("QQQQQQQQ"));
    }
}
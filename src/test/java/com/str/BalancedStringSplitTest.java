package com.str;

import org.junit.Test;

import static org.junit.Assert.*;

public class BalancedStringSplitTest {

    @Test
    public void balancedStringSplit() {
        BalancedStringSplit obj = new BalancedStringSplit();
        assertEquals(obj.balancedStringSplit("RLRRLLRLRL"), 4);
        assertEquals(obj.balancedStringSplit("RLLLLRRRLR"), 3);
        assertEquals(obj.balancedStringSplit("LLLLRRRR"), 1);
        assertEquals(obj.balancedStringSplit("RLRRRLLRLL"), 2);

    }
}
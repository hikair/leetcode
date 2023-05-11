package com.str.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueryStringTest {

    QueryString obj = new QueryString();

    @Test
    public void queryString() {
        assertTrue(obj.queryString("0110", 3));
        assertFalse(obj.queryString("0110", 4));
    }
}
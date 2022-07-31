package com.str.simple;

import org.junit.Test;

import static org.junit.Assert.*;

public class GenerateTheStringTest {

    GenerateTheString obj = new GenerateTheString();

    @Test
    public void generateTheString() {
        assertEquals("aaa", obj.generateTheString(3));
        assertEquals("aaab", obj.generateTheString(4));
    }
}
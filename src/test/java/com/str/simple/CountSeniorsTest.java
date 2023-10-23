package com.str.simple;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountSeniorsTest {

    CountSeniors obj = new CountSeniors();

    @Test
    public void countSeniors() {
        assertEquals(2, obj.countSeniors(new String[]{"7868190130M7522", "5303914400F9211", "9273338290F4010"}));
    }
}
package com.dp.middle;

import org.junit.Assert;
import org.junit.Test;


public class FindSubstringInWraproundStringTest {

    FindSubstringInWraproundString obj = new FindSubstringInWraproundString();

    @Test
    public void findSubstringInWraproundString() {
//        Assert.assertEquals(1, obj.findSubstringInWraproundString("a"));
//        Assert.assertEquals(2, obj.findSubstringInWraproundString("cac"));
        Assert.assertEquals(6, obj.findSubstringInWraproundString("zab"));
    }
}
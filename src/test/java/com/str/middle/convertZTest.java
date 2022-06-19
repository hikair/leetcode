package com.str.middle;

import org.junit.Assert;
import org.junit.Test;


public class convertZTest {

    convertZ obj = new convertZ();

    @Test
    public void convert() {
        Assert.assertEquals("PAHNAPLSIIGYIR", obj.convert("PAYPALISHIRING", 3));
        Assert.assertEquals("PINALSIGYAHRPI", obj.convert("PAYPALISHIRING", 4));
    }
}
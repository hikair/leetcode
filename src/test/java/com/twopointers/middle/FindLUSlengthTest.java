package com.twopointers.middle;

import org.junit.Assert;
import org.junit.Test;

public class FindLUSlengthTest {

    FindLUSlength obj = new FindLUSlength();

    @Test
    public void findLUSlength() {
        Assert.assertEquals(3, obj.findLUSlength(new String[]{"aba", "cdc", "eae"}));
        Assert.assertEquals(-1, obj.findLUSlength(new String[]{"aaa", "aaa", "aa"}));
    }
}
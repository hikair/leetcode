package com.hash.middle;

import org.junit.Assert;
import org.junit.Test;


public class FindPairsTest {

    FindPairs obj = new FindPairs();

    @Test
    public void findPairs() {
        Assert.assertEquals(2, obj.findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        Assert.assertEquals(4, obj.findPairs(new int[]{1, 2, 3, 4, 5}, 1));
        Assert.assertEquals(1, obj.findPairs(new int[]{1, 3, 1, 5, 4}, 0));
        Assert.assertEquals(2, obj.findPairs(new int[]{1, 1, 1, 2, 2}, 0));
    }
}
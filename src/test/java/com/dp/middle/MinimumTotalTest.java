package com.dp.middle;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class MinimumTotalTest {

    MinimumTotal obj = new MinimumTotal();

    @Test
    public void minimumTotal() {
        List<List<Integer>> triangle = Lists.newArrayList(Lists.newArrayList(2),
                Lists.newArrayList(3, 4),
                Lists.newArrayList(6, 5, 9),
                Lists.newArrayList(4, 4, 8, 0));
        Assert.assertEquals(14, obj.minimumTotal(triangle));


        triangle = Lists.newArrayList(Lists.newArrayList(2),
                Lists.newArrayList(3, 4),
                Lists.newArrayList(6, 5, 7),
                Lists.newArrayList(4, 1, 8, 3));
        Assert.assertEquals(11, obj.minimumTotal(triangle));
    }
}
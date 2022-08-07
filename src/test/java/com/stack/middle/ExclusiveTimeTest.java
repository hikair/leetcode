package com.stack.middle;

import com.google.common.collect.Lists;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExclusiveTimeTest {

    ExclusiveTime obj = new ExclusiveTime();

    @Test
    public void exclusiveTime() {
        assertArrayEquals(new int[]{3, 4}, obj.exclusiveTime(2, Lists.newArrayList("0:start:0","1:start:2","1:end:5","0:end:6")));
        assertArrayEquals(new int[]{8}, obj.exclusiveTime(1, Lists.newArrayList("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7")));
        assertArrayEquals(new int[]{7, 1}, obj.exclusiveTime(2, Lists.newArrayList("0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7")));
        assertArrayEquals(new int[]{1}, obj.exclusiveTime(1, Lists.newArrayList("0:start:0","0:end:0")));
    }
}
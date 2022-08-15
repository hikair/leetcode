package com.hash.simple;

import com.google.common.collect.Lists;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderedStreamTest {

    @Test
    public void insert() {
        OrderedStream obj = new OrderedStream(5);
        assertTrue(Lists.newArrayList().containsAll(obj.insert(3, "ccccc")));
        assertTrue(Lists.newArrayList("aaaaa").containsAll(obj.insert(1, "aaaaa")));
        assertTrue(Lists.newArrayList("bbbbb", "ccccc").containsAll(obj.insert(2, "bbbbb")));
        assertTrue(Lists.newArrayList().containsAll(obj.insert(5, "eeeee")));
        assertTrue(Lists.newArrayList("ddddd", "eeeee").containsAll(obj.insert(4, "ddddd")));
    }
}
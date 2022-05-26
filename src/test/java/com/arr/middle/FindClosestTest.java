package com.arr.middle;

import org.junit.Assert;
import org.junit.Test;


public class FindClosestTest {

    FindClosest obj = new FindClosest();

    @Test
    public void findClosest() {
        String[] words = new String[]{"I","am","a","student","from","a","university","in","a","city"};
        Assert.assertEquals(1, obj.findClosest(words, "a", "student"));
    }
}
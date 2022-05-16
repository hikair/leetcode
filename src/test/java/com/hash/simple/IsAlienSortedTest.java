package com.hash.simple;

import org.junit.Assert;
import org.junit.Test;


public class IsAlienSortedTest {

    IsAlienSorted obj = new IsAlienSorted();

    @Test
    public void isAlienSorted() {
        Assert.assertTrue(obj.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        Assert.assertFalse(obj.isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        Assert.assertFalse(obj.isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}
package com.hash.simple;

import org.junit.Assert;
import org.junit.Test;

public class IsAnagramTest {

    IsAnagram obj = new IsAnagram();

    @Test
    public void isAnagram() {
        Assert.assertTrue(obj.isAnagram("anagram", "nagaram"));
        Assert.assertFalse(obj.isAnagram("rat", "car"));
    }
}
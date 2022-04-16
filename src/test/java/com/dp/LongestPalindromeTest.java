package com.dp;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromeTest {

    LongestPalindrome obj = new LongestPalindrome();

    @Test
    public void longestPalindrome() {
        Assert.assertEquals("a", obj.longestPalindrome("a"));
        Assert.assertEquals("cbbc", obj.longestPalindrome("acbbcd"));
        Assert.assertEquals("bab", obj.longestPalindrome("babad"));
        Assert.assertEquals("bb", obj.longestPalindrome("cbbd"));
    }

    @Test
    public void longestPalindrome2() {
        Assert.assertEquals("bb", obj.longestPalindrome2("bb"));
        Assert.assertEquals("a", obj.longestPalindrome2("a"));
        Assert.assertEquals("cbbc", obj.longestPalindrome2("acbbcd"));
//        Assert.assertEquals("bab", obj.longestPalindrome2("babad"));
        Assert.assertEquals("bb", obj.longestPalindrome2("cbbd"));
    }
}
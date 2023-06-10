package com.hash.middle;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class NumSmallerByFrequencyTest {

    NumSmallerByFrequency obj = new NumSmallerByFrequency();

    @Test
    public void numSmallerByFrequency() {
        System.out.println(Arrays.toString(obj.numSmallerByFrequency(new String[]{"bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"}, new String[]{"aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"})));
        System.out.println(Arrays.toString(obj.numSmallerByFrequency(new String[]{"bbb", "cc"}, new String[]{"a", "aa", "aaa", "aaaa"})));
    }
}
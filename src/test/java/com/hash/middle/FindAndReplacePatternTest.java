package com.hash.middle;

import org.junit.Test;

import java.util.List;


public class FindAndReplacePatternTest {

    FindAndReplacePattern obj = new FindAndReplacePattern();

    @Test
    public void findAndReplacePattern() {
        List<String> ans = obj.findAndReplacePattern(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb");
        System.out.println(ans);
    }
}
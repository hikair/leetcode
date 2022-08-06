package com.str.simple;

import com.google.common.collect.Lists;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringMatchingTest {

    StringMatching obj = new StringMatching();

    @Test
    public void stringMatching() {
        assertTrue(Lists.newArrayList("leetcode", "od", "am").containsAll(obj.stringMatching(new String[]{"leetcoder", "leetcode", "od", "hamlet", "am"})));
        assertTrue(Lists.newArrayList("as", "hero").containsAll(obj.stringMatching(new String[]{"mass", "as", "hero", "superhero"})));
        assertTrue(Lists.newArrayList("et", "code").containsAll(obj.stringMatching(new String[]{"leetcode", "et", "code"})));
        assertTrue(Lists.newArrayList().containsAll(obj.stringMatching(new String[]{"blue", "green", "bu"})));
    }
}
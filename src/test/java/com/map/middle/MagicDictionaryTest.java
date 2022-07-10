package com.map.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class MagicDictionaryTest {

    MagicDictionary obj = new MagicDictionary();

    @Test
    public void search() {
        obj.buildDict(new String[]{"hello", "leetcode"});
        assertFalse(obj.search("hello"));
        assertTrue(obj.search("hhllo"));
        assertFalse(obj.search("hell"));
        assertFalse(obj.search("leetcoded"));
    }
}
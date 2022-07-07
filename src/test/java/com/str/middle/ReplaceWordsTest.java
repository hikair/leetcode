package com.str.middle;

import com.google.common.collect.Lists;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReplaceWordsTest {

    ReplaceWords obj = new ReplaceWords();

    @Test
    public void replaceWords() {
        assertEquals("the cat was rat by the bat", obj.replaceWords(Lists.newArrayList("cat","bat","rat"), "the cattle was rattled by the battery"));
        assertEquals("a a b c", obj.replaceWords(Lists.newArrayList("a","b","c"), "aadsfasf absbs bbab cadsfafs"));
        assertEquals("a a a a a a a a bbb baba a", obj.replaceWords(Lists.newArrayList("a", "aa", "aaa", "aaaa"), "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"));
    }
}
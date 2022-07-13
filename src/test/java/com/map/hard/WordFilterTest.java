package com.map.hard;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordFilterTest {

    @Test
    public void wordFilter() {
        WordFilter obj = new WordFilter(new String[]{"apple"});
        assertEquals(0, obj.f("a", "e"));
    }
}
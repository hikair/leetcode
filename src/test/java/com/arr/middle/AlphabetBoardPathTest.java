package com.arr.middle;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

@Ignore
public class AlphabetBoardPathTest {

    AlphabetBoardPath obj = new AlphabetBoardPath();

    @Test
    public void alphabetBoardPath() {
        assertEquals("RDD!RRRUU!!DDD!", obj.alphabetBoardPath("leet"));
        assertEquals("RR!RRDD!LUU!R!", obj.alphabetBoardPath("code"));
        assertEquals("DDDDD!UR!", obj.alphabetBoardPath("zv"));
        assertEquals("RDDDD!LD!", obj.alphabetBoardPath("vz"));
    }
}
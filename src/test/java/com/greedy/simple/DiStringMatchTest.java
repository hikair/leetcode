package com.greedy.simple;

import org.junit.Test;

import java.util.Arrays;

public class DiStringMatchTest {

    DiStringMatch obj = new DiStringMatch();

    @Test
    public void diStringMatch() {
        System.out.println(Arrays.toString(obj.diStringMatch("IDID")));
        System.out.println(Arrays.toString(obj.diStringMatch("III")));
        System.out.println(Arrays.toString(obj.diStringMatch("DII")));
    }
}
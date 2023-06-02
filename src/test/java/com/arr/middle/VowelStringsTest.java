package com.arr.middle;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class VowelStringsTest {

    VowelStrings obj = new VowelStrings();

    @Test
    public void vowelStrings() {
        System.out.println(Arrays.toString(obj.vowelStrings(new String[]{"aba", "bcb", "ece", "aa", "e"}, new int[][]{{0, 2}, {1, 4}, {1, 1}})));
        System.out.println(Arrays.toString(obj.vowelStrings(new String[]{"a", "e", "i"}, new int[][]{{0, 2}, {0, 1}, {2, 2}})));
    }
}
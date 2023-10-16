package com.arr.middle;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SingleNumberTest {

    SingleNumber obj = new SingleNumber();

    @Test
    public void singleNumber() {
        System.out.println(Arrays.toString(obj.singleNumber(new int[]{-1, 0})));
        System.out.println(Arrays.toString(obj.singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }
}
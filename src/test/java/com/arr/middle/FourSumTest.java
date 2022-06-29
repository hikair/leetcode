package com.arr.middle;

import org.junit.Test;

public class FourSumTest {

    FourSum obj = new FourSum();

    @Test
    public void fourSum() {
        // [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        System.out.println(obj.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        // [[2,2,2,2]]
        System.out.println(obj.fourSum(new int[]{2, 2, 2, 2}, 8));
    }
}
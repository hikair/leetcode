package com.arr.middle;

import org.junit.Test;

import java.util.List;

public class ThreeSumTest {

    ThreeSum obj = new ThreeSum();

    @Test
    public void threeSum() {
        List<List<Integer>> lists = obj.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
        lists = obj.threeSum(new int[]{});
        System.out.println(lists);
        lists = obj.threeSum(new int[]{0});
        System.out.println(lists);
    }
}
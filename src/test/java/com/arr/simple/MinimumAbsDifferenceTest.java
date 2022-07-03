package com.arr.simple;

import org.junit.Test;

public class MinimumAbsDifferenceTest {

    MinimumAbsDifference obj = new MinimumAbsDifference();

    @Test
    public void minimumAbsDifference() {
        System.out.println(obj.minimumAbsDifference(new int[]{4, 2, 1, 3}));
        System.out.println(obj.minimumAbsDifference(new int[]{1, 3, 6, 10, 15}));
        System.out.println(obj.minimumAbsDifference(new int[]{3, 8, -10, 23, 19, -4, -14, 27}));
    }
}
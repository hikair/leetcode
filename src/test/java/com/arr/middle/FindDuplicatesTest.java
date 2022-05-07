package com.arr.middle;

import org.junit.Test;

public class FindDuplicatesTest {

    FindDuplicates obj = new FindDuplicates();

    @Test
    public void findDuplicates() {
        System.out.println(obj.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1})); // 2, 3
        System.out.println(obj.findDuplicates(new int[]{1, 1, 2})); // 1
        System.out.println(obj.findDuplicates(new int[]{1}));
    }
}
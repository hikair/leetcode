package com.num.middle;

import org.junit.Assert;
import org.junit.Test;

public class NextPermutationTest {

    NextPermutation obj = new NextPermutation();

    @Test
    public void nextPermutation() {
        int[] nums = new int[]{1, 2, 3};
        obj.nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{1, 3, 2}, nums);
        nums = new int[]{1, 2, 3, 8, 5, 7, 6, 4};
        obj.nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 8, 6, 4, 5, 7}, nums);
        nums = new int[]{3, 2, 1};
        obj.nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{1, 2, 3}, nums);
    }
}
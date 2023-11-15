package com.arr.simple;

import java.util.Arrays;

/**
 * 2656. K 个元素的最大和
 */
public class MaximizeSum {

    public int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        int x = nums[nums.length - 1];
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans += x;
            x++;
        }
        return ans;
    }
}

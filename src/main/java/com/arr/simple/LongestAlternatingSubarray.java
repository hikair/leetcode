package com.arr.simple;

/**
 * 2760. 最长奇偶子数组
 */
public class LongestAlternatingSubarray {

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length, ans = 0;
        int[] dp = new int[n];
        if (nums[0] <= threshold && nums[0] % 2 == 0) {
            dp[0] = 1;
            ans = 1;
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] > threshold) {
                continue;
            }
            if (nums[i] % 2 != nums[i - 1] % 2 && dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = nums[i] % 2 == 0 ? 1 : 0;

            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}

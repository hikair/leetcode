package com.arr.middle;

import java.util.Arrays;

/**
 * 260. 只出现一次的数字 III
 * <p>
 * 给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * <p>
 * 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
 * <p>
 * https://leetcode.cn/problems/single-number-iii
 */
public class SingleNumber {

    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, p = 0;
        int[] ans = new int[2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (nums[i] != nums[i + 1]) {
                    ans[p++] = nums[i];
                }
                continue;
            }
            if (nums[i] != nums[i - 1] && (i == n - 1 || nums[i] != nums[i + 1])) {
                ans[p++] = nums[i];
            }
        }
        return ans;
    }
}

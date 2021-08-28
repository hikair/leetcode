package com.arr;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^4
 * -10^5 <= nums[i] <= 10^5
 *  
 *
 * 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] copy = nums.clone();
        Arrays.sort(copy);
        int i = 0, j = n - 1;
        for (; i < n; i++) {
            if(copy[i] != nums[i]) break;
        }

        for(; j > 0; j--) {
            if(copy[j] != nums[j]) break;
        }
        return i == n ? 0 : j - i + 1;
    }

    public static void main(String[] args) {
        FindUnsortedSubarray obj = new FindUnsortedSubarray();
        System.out.println(obj.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(obj.findUnsortedSubarray(new int[]{1,3,2,2,2}));//4
        System.out.println(obj.findUnsortedSubarray(new int[]{1,3,2,3,3}));//2
        System.out.println(obj.findUnsortedSubarray(new int[]{1,3,6,6,6}));
        System.out.println(obj.findUnsortedSubarray(new int[]{1,1,1,1,1}));
        System.out.println(obj.findUnsortedSubarray(new int[]{1}));

        System.out.println(obj.findUnsortedSubarray(new int[]{1,2,3,4}));
        System.out.println(obj.findUnsortedSubarray(new int[]{}));
    }
}

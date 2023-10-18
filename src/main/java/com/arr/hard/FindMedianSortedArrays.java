package com.arr.hard;

import java.util.Arrays;

/**
 * 4. 寻找两个正序数组的中位数
 * <p>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/description/
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int a = m + n;
        int[] arr = new int[a];
        for (int i = 0; i < m; i++) {
            arr[i] = nums1[i];
        }
        for (int i = 0; i < n; i++) {
            arr[i + m] = nums2[i];
        }
        Arrays.sort(arr);
        if (a % 2 == 1) {
            return arr[a / 2];
        }

        int s = arr[a / 2] + arr[a / 2 - 1];
        if (s % 2 == 0) {
            return s / 2;
        }
        return s / 2 + 0.5;
    }
}

package com.greedy.middle;

import java.util.Arrays;

/**
 * 1465. 切割后面积最大的蛋糕
 */
public class MaxArea {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        return (int) ((long) getLongestLength(horizontalCuts, h) * getLongestLength(verticalCuts, w) % 1000000007);
    }

    private int getLongestLength(int[] arr, int x) {
        int len, maxLen = 0;
        for (int i = 0; i <= arr.length; i++) {
            if (i == 0) {
                len = arr[i];
            } else if (i == arr.length) {
                len = x - arr[i - 1];
            } else {
                len = arr[i] - arr[i - 1];
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}

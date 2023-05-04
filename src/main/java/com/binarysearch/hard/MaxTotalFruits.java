package com.binarysearch.hard;

import java.util.TreeMap;

/**
 * 2106. 摘水果
 * https://leetcode.cn/problems/maximum-fruits-harvested-after-at-most-k-steps/
 */
public class MaxTotalFruits {

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int ans = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] fruit : fruits) {
            map.put(fruit[0], fruit[1]);
        }
        for (int x = 0; x <= k / 2; x++) {
            ans = Math.max(ans, countFruits(map, startPos - x, startPos + k - 2 * x));
            ans = Math.max(ans, countFruits(map, startPos - k + 2 * x, startPos + x));
        }
        return ans;
    }

    private int countFruits(TreeMap<Integer, Integer> map, int start, int end) {
        int sum = 0;
        for (Integer value : map.subMap(start, end + 1).values()) {
            sum += value;
        }
        return sum;
    }
}

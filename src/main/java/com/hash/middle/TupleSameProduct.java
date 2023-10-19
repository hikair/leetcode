package com.hash.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * 1726. 同积元组
 * <p>
 * 给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。其中 a、b、c 和 d 都是 nums 中的元素，且 a != b != c != d 。
 * <p>
 * https://leetcode.cn/problems/tuple-with-same-product
 */
public class TupleSameProduct {

    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        if (n < 4) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int t = nums[i] * nums[j];
                map.put(t, map.getOrDefault(t, -1) + 1);
            }
        }
        return 8 * map.values().stream().filter(e -> e > 0).mapToInt(e -> e * (e + 1) / 2).sum();
    }
}

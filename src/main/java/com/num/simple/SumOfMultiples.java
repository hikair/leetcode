package com.num.simple;

/**
 * 2652. 倍数求和
 * <p>
 * 给你一个正整数 n ，请你计算在 [1，n] 范围内能被 3、5、7 整除的所有整数之和。
 * <p>
 * 返回一个整数，用于表示给定范围内所有满足约束条件的数字之和。
 * <p>
 * https://leetcode.cn/problems/sum-multiples/description
 */
public class SumOfMultiples {

    public int sumOfMultiples(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                ans += i;
            }
        }
        return ans;
    }
}

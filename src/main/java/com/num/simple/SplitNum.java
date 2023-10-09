package com.num.simple;

import java.util.Arrays;

/**
 * 给你一个正整数 num ，请你将它分割成两个非负整数 num1 和 num2 ，满足：
 * <p>
 * num1 和 num2 直接连起来，得到 num 各数位的一个排列。
 * 换句话说，num1 和 num2 中所有数字出现的次数之和等于 num 中所有数字出现的次数。
 * num1 和 num2 可以包含前导 0 。
 * 请你返回 num1 和 num2 可以得到的和的 最小 值。
 * <p>
 * 注意：
 * <p>
 * num 保证没有前导 0 。
 * num1 和 num2 中数位顺序可以与 num 中数位顺序不同。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 4325
 * 输出：59
 * 解释：我们可以将 4325 分割成 num1 = 24 和 num2 = 35 ，和为 59 ，59 是最小和。
 * 示例 2：
 * <p>
 * 输入：num = 687
 * 输出：75
 * 解释：我们可以将 687 分割成 num1 = 68 和 num2 = 7 ，和为最优值 75 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 10 <= num <= 10^9
 * <p>
 * https://leetcode.cn/problems/split-with-minimum-sum
 */
public class SplitNum {
    public int splitNum(int num) {
        char[] cs = String.valueOf(num).replace("0", "").toCharArray();
        Arrays.sort(cs);
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder("0");
        for (int i = 0; i < cs.length; i++) {
            if (i % 2 == 0) {
                left.append(cs[i]);
            } else {
                right.append(cs[i]);
            }
        }
        return Integer.parseInt(left.toString()) + Integer.parseInt(right.toString());
    }
}

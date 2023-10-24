package com.dp.middle;

/**
 * 1155. 掷骰子等于目标和的方法数
 * <p>
 * 这里有 n 个一样的骰子，每个骰子上都有 k 个面，分别标号为 1 到 k 。
 * <p>
 * 给定三个整数 n ,  k 和 target ，返回可能的方式(从总共 kn 种方式中)滚动骰子的数量，使正面朝上的数字之和等于 target 。
 * <p>
 * 答案可能很大，你需要对 109 + 7 取模 。
 * <p>
 * https://leetcode.cn/problems/number-of-dice-rolls-with-target-sum/description/
 */
public class NumRollsToTarget {

    private static final int MOD = 1000000007;

    /**
     * n - 1 个骰子 掷出 x 有 y 种可能性
     * n 个骰子掷出 x + [1, k] 有 y + 1 种可能性
     * dp[i][j] 表示 掷 i 个骰子，投出 j 值有多少种可能性
     */
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 1; i <= k && i <= target; i++) {
            dp[1][i] = 1;
        }
        // 骰子数量
        for (int i = 2; i <= n; i++) {
            // 最后一个骰子投出的值
            for (int j = 1; j <= k; j++) {
                for (int l = 1; l <= target - j; l++) {
                    dp[i][l + j] = (dp[i][l + j] + dp[i - 1][l]) % MOD;
                }
            }
        }
        return dp[n][target] % MOD;
    }
}

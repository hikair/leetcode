package com.dp.middle;

public class MaxValues {

    /**
     * dp[i][j] 装前 i 个物品剩余 j 重量时，装的最大价值
     */
    public int maxValues(int[] weights, int[] values, int totalWeight) {
        int n = weights.length;
        int[][] dp = new int[n + 1][totalWeight + 1];

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= totalWeight; j++) {
                // 当前物品重量大于剩余可用重量
                if (weights[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                }
            }
        }
        return dp[n][totalWeight];
    }
}

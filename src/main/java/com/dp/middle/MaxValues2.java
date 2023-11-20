package com.dp.middle;

public class MaxValues2 {

    /**
     * dp[i][j] 装前 i 个物品剩余 j 重量时，装的最大价值
     */
    public int maxValues2(int[] weights, int[] values, int totalWeight) {
        int n = weights.length;
        int[][] dp = new int[n + 1][totalWeight + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totalWeight; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 1; k <= j / weights[i - 1]; k++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1] * k] + values[i - 1] * k);
                }
            }
        }
        return dp[n][totalWeight];
    }
}

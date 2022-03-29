package com.dp;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 *
 * 提示：
 *
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int[] f = new int[prices.length];
        f[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                maxVal = Math.max(maxVal,prices[i] - prices[j]);
            }
            f[i] = Math.max(f[i-1],maxVal);
        }
        return f[prices.length - 1];
    }


    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];

        // dp[x] 表示第x天历史价格最低值
        dp[0] = prices[0];
        // 定义一个临时变量，表示最大收益
        int maxVal = 0;
        for (int i = 1; i < n; i++) {
            // 转移方程
            dp[i] = Math.min(dp[i-1],prices[i]);
            maxVal = Math.max(maxVal,prices[i] -dp[i]);
        }
        return maxVal;
    }

    public int maxProfit3(int[] prices) {
        int n = prices.length;

        // dp 表示历史价格最低值
        int dp = prices[0];
        // 定义一个临时变量，表示最大收益
        int maxVal = 0;
        for (int i = 1; i < n; i++) {
            // 转移方程
            dp = Math.min(dp,prices[i]);
            maxVal = Math.max(maxVal,prices[i] -dp);
        }
        return maxVal;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit3(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit.maxProfit3(new int[]{7,6,4,3,1}));
    }
}

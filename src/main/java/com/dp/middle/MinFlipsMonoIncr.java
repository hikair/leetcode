package com.dp.middle;

/**
 * 如果一个二进制字符串，是以一些 0（可能没有 0）后面跟着一些 1（也可能没有 1）的形式组成的，那么该字符串是 单调递增 的。
 * <p>
 * 给你一个二进制字符串 s，你可以将任何 0 翻转为 1 或者将 1 翻转为 0 。
 * <p>
 * 返回使 s 单调递增的最小翻转次数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "00110"
 * 输出：1
 * 解释：翻转最后一位得到 00111.
 * 示例 2：
 * <p>
 * 输入：s = "010110"
 * 输出：2
 * 解释：翻转得到 011111，或者是 000111。
 * 示例 3：
 * <p>
 * 输入：s = "00011000"
 * 输出：2
 * 解释：翻转得到 00000000。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * s[i] 为 '0' 或 '1'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/flip-string-to-monotone-increasing
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinFlipsMonoIncr {

    public int minFlipsMonoIncr(String s) {
        int dp0 = 0, dp1 = 0;
        for (char c : s.toCharArray()) {
            dp1 = Math.min(dp0, dp1) + '1' - c;
            dp0 += c - '0';
        }
        return Math.min(dp0, dp1);
    }

    /**
     * dp[i][j] 表示当前下标i，用j时所用的最小反转次数
     * @param s
     * @return
     */
    public int minFlipsMonoIncr2(String s) {
        int len = s.length();
        int[][] dp = new int[len][2];
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (i == 0) {
                if (c == '0') {
                    dp[i][1] = 1;
                } else {
                    dp[i][0] = 1;
                }
            } else {
                // 当填充'0'时，前一步只能是0，并判断当前是否需要反转
                dp[i][0] = dp[i - 1][0] + c - '0';
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (c == '0' ? 1 : 0);
            }
        }
        return Math.min(dp[len - 1][0], dp[len - 1][1]);
    }
}

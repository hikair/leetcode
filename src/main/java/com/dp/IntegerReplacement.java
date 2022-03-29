package com.dp;

/**
 * 给定一个正整数 n ，你可以做如下操作：
 *
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * n 变为 1 所需的最小替换次数是多少？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 * 示例 3：
 *
 * 输入：n = 4
 * 输出：2
 *  
 *
 * 提示：
 *
 * 1 <= n <= 2^31 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntegerReplacement {

    /**
     * dp[8] = 3, dp[7] = 4, dp[6] = 3, dp[5] = 3, dp[4] = 2, dp[3] = 2, dp[2] = 1, dp[1] = 0
     * dp[x] =
     * case x % 2 = 0: dp[x/2] + 1
     * case x % 2 = 1: min{dp[x - 1] + 1, dp[x + 1] + 1} 即 min{dp[x - 1] + 1, dp[(x + 1) / 2] + 2}
     * @param n 当n = 100000000时，超出内存限制！！！
     * @return
     */
    public int integerReplacement(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i < n + 1; i++) {
            if ((i & 1) == 0) {
                dp[i] = dp[i / 2] + 1;
            } else {
                dp[i] = Math.min(dp[i - 1] + 1, dp[(i + 1) / 2] + 2);
            }
        }
        return dp[n];
    }

}

package com.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10^n 。
 *  
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：91
 * 解释：答案应为除去 11、22、33、44、55、66、77、88、99 外，在 0 ≤ x < 100 范围内的所有数字。
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：1
 *  
 *
 * 提示：
 *
 * 0 <= n <= 8
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-numbers-with-unique-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountNumbersWithUniqueDigits {
    /**
     * dp[x] = dp[x - 1] + 10^n - 10^(n-1) - [10^(n-1),10^n)范围内有相同数字的情况个数
     * 会超时
     * @param n
     * @return
     */
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int begin, end;
        for (int i = 1; i <= n; i++) {
            begin = (int)Math.pow(10, i - 1);
            end = (int)Math.pow(10, i);
            dp[i] = dp[i - 1] + end - begin - sameCount(begin, end, i);
        }
        return dp[n];
    }

    private int sameCount(int begin, int end, int n) {
        int count = 0;
        while(begin < end) {
            count += hasSame(begin, n) ? 1 : 0;
            begin++;
        }
        return count;
    }

    private boolean hasSame(int x, int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(x % 10);
            x /= 10;
        }
        return set.size() < n;
    }

    /**
     * dp[x] = dp[x - 1] + n位数每位都不同的个数
     * n = 2, [10, 100)可以看做2位， 第一位可取范围1~9 9个数，第二位可取范围0~9 10个数但是由于不能与第一位数相同所以是9个，这样一来，就有81个数
     * 加上n = 1的情况91种
     * n = 3, [100, 1000)可以看做3位， 第一位可取范围1~9 9个数，第二位可取范围0~9 10个数但是由于不能与第一位数相同所以是9个，第三位可取范围0~9 10个数
     * 单数不能与第一位、第二位数相同，只有8个了，那么最终3位数的个数为9*9*8 = 648种，加上2位数91种，和一位数10种，739种
     * n = 4 dp[3] + 9 * 9 * 8 * 7 = 5275
     * ...
     * 可得转移方程：dp[x] = dp[x - 1] + (dp[x - 1] - dp[x - 2]) * (11 - x)
     * @param n
     * @return
     */
    public int countNumbersWithUniqueDigits2(int n) {
        if (n == 0) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 10;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + (dp[i - 1] - dp[i - 2]) * (11 - i);
        }
        return dp[n];
    }
}

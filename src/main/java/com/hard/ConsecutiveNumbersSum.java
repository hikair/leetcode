package com.hard;

/**
 * 给定一个正整数 n，返回 连续正整数满足所有数字之和为 n 的组数 。 
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 5
 * 输出: 2
 * 解释: 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。
 * 示例 2:
 * <p>
 * 输入: n = 9
 * 输出: 3
 * 解释: 9 = 4 + 5 = 2 + 3 + 4
 * 示例 3:
 * <p>
 * 输入: n = 15
 * 输出: 4
 * 解释: 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 10^9​​​​​​​
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/consecutive-numbers-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConsecutiveNumbersSum {

    /**
     * 以9为例
     * 可以看做
     * 9 / 1 = 9   9
     * 8 / 2 = 4   4 + 4 + 减掉的1
     * 6 / 3 = 2   2 + 2 + 2 + 减掉的3
     * @param n
     * @return
     */
    public int consecutiveNumbersSum(int n) {
        int ans = 0;
        for (int i = 1; n > 0 ; n -= i++) {
            if (n % i == 0) {
                ans++;
            }
        }
        return ans;
    }
}

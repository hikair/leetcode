package com.dp;

/**
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：[0,1,1]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：[0,1,1,2,1,2]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *  
 *
 * 提示：
 *
 * 0 <= n <= 10^5
 *  
 *
 * 进阶：
 *
 * 很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？
 * 你能不使用任何内置函数解决此问题吗？（如，C++ 中的 __builtin_popcount ）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountBits {

    /**
     * 最低有效位
     * 对于整数x，将其右移一位，等价于将数x除以2，那么比特位就是 x / 2的比特位 + x是不是奇数? 1 : 0
     * dp[x] = dp[x >> 1] + (x & 1)
     * @param n
     * @return
     */
    public int[] countBits2(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }

    /**
     * 最高有效位
     * 对于任何大于0的数x，如果x是2的幂，比特位为1，如果x不是2的幂
     * 存在一个小于x的最大的2的幂的y，那么x的比特位等于 1 + (x - y)的比特位
     * @param n
     * @return
     */
    public int[] countBits3(int n) {
        int[] dp = new int[n + 1];
        int high = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                high = i;
            }
            dp[i] = dp[i - high] + 1;
        }
        return dp;
    }

    public int[] countBits4(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = countOnes(i);
        }
        return ans;
    }

    public int countOnes(int x) {
        int count = 0;
        while(x > 0) {
            count++;
            x &= (x - 1);
        }
        return count;
    }

    public int[] countBits5(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = Integer.bitCount(i);
        }
        return ans;
    }
}

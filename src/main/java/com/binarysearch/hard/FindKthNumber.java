package com.binarysearch.hard;

import java.util.PriorityQueue;

/**
 * 几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？
 *
 * 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。
 *
 * 例 1：
 *
 * 输入: m = 3, n = 3, k = 5
 * 输出: 3
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 * 3	6	9
 *
 * 第5小的数字是 3 (1, 2, 2, 3, 3).
 * 例 2：
 *
 * 输入: m = 2, n = 3, k = 6
 * 输出: 6
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 *
 * 第6小的数字是 6 (1, 2, 2, 3, 4, 6).
 * 注意：
 *
 * m 和 n 的范围在 [1, 30000] 之间。
 * k 的范围在 [1, m * n] 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindKthNumber {

    /**
     * 原问题可等价于有多少个数字不超过x
     * 对于任一行i，其元素为i, 2i, 3i, 4i,..., ni
     * 那么这一行小于x的个数为 ni < x， n < x / i，但最小也是n
     * 总个数为 1 ～ i行，min(x/i, n)之和
     * 细节：当i <= x / n时，可以简化为x / n * n
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int findKthNumber(int m, int n, int k) {
        int l = 0, r = m * n;
        while(l < r) {
            int x = l + (r - l) / 2;
            int count = x / n * n;
            for (int i = x / n + 1; i <= m; i++) {
                count += x / i;
            }
            if (count < k) {
                l = x + 1;
            } else {
                r = x;
            }
        }
        return l;
    }

    // 超出内存限制
    public int findKthNumber2(int m, int n, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(m * n);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                queue.add(i * j);
            }
        }
        for (int i = 1; i < k; i++) {
            queue.remove();
        }
        return queue.peek();
    }
}

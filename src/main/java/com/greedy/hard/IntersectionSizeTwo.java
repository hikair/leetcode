package com.greedy.hard;

import java.util.Arrays;

/**
 * 一个整数区间 [a, b]  ( a < b ) 代表着从 a 到 b 的所有连续整数，包括 a 和 b。
 * <p>
 * 给你一组整数区间intervals，请找到一个最小的集合 S，使得 S 里的元素与区间intervals中的每一个整数区间都至少有2个元素相交。
 * <p>
 * 输出这个最小集合S的大小。
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1, 3], [1, 4], [2, 5], [3, 5]]
 * 输出: 3
 * 解释:
 * 考虑集合 S = {2, 3, 4}. S与intervals中的四个区间都有至少2个相交的元素。
 * 且这是S最小的情况，故我们输出3。
 * 示例 2:
 * <p>
 * 输入: intervals = [[1, 2], [2, 3], [2, 4], [4, 5]]
 * 输出: 5
 * 解释:
 * 最小的集合S = {1, 2, 3, 4, 5}.
 * 注意:
 * <p>
 * intervals 的长度范围为[1, 3000]。
 * intervals[i] 长度为 2，分别代表左、右边界。
 * intervals[i][j] 的值是 [0, 10^8]范围内的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/set-intersection-size-at-least-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntersectionSizeTwo {

    /**
     * 先按照右边界升序
     * 再按照左边界降序，这样做的好处是，如果交集在较小范围内，那么也必然也是较大范围的交集，ex: [3, 5], [2, 5]
     * 两个交集元素必然有 end = intervals[0][1], pre_end = end - 1
     * 对于intervals后的每一个元素， xi = intervals[i][0], yi = intervals[i][1],  yi必然大于等于end, 那么只需要分类讨论xi与pre_end、end的大小关系
     *
     * @param intervals
     * @return
     */
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        int ans = 2, end = intervals[0][1], n = intervals.length;
        int preEnd = end - 1;
        for (int i = 1; i < n; i++) {
            int xi = intervals[i][0];
            int yi = intervals[i][1];
            if (xi <= preEnd) {
                continue;
            }
            if (xi <= end) {
                ans++;
                preEnd = end;
                end = yi;
            } else {
                ans += 2;
                preEnd = yi - 1;
                end = yi;
            }
        }
        return ans;
    }
}

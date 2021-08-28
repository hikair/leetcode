package com.other;

import java.util.Arrays;

/**
 * 给你一个二维整数数组 ranges 和两个整数 left 和 right 。每个 ranges[i] = [starti, endi] 表示一个从 starti 到 endi 的 闭区间 。
 *
 * 如果闭区间 [left, right] 内每个整数都被 ranges 中 至少一个 区间覆盖，那么请你返回 true ，否则返回 false 。
 *
 * 已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi ，那么我们称整数x 被覆盖了。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
 * 输出：true
 * 解释：2 到 5 的每个整数都被覆盖了：
 * - 2 被第一个区间覆盖。
 * - 3 和 4 被第二个区间覆盖。
 * - 5 被第三个区间覆盖。
 * 示例 2：
 *
 * 输入：ranges = [[1,10],[10,20]], left = 21, right = 21
 * 输出：false
 * 解释：21 没有被任何一个区间覆盖。
 *  
 *
 * 提示：
 *
 * 1 <= ranges.length <= 50
 * 1 <= starti <= endi <= 50
 * 1 <= left <= right <= 50
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsCovered {

    public boolean isCovered(int[][] ranges, int left, int right) {
        int n = ranges.length;
        int l = ranges[0][0], r = ranges[0][1];
        for (int i = 1; i < n; i++) {
            r = ranges[i][0];
            if(ranges[i][0] - r > 1) {
                l = ranges[i][0];
            }
            if(l <= left && r >= right) {
                return true;
            }
        }
        return l <= left && r >= right;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2}, {3,4}, {5,6}};

        int[][] arr2 = new int[][]{{25,42}, {7,14}, {2,32}, {25,28}, {39,49}, {1,50}, {29,45}, {18,47}};

        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));

        IsCovered obj = new IsCovered();
        System.out.println(obj.isCovered(arr, 2, 5));
        System.out.println(obj.isCovered(new int[][]{{1, 10},{10, 20}}, 21, 21));
        System.out.println(obj.isCovered(new int[][]{{1,50}}, 1, 50));
    }
}

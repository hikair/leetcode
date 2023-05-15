package com.arr.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * 1072. 按列翻转得到最大值等行数
 * <p>
 * 给定 m x n 矩阵 matrix 。
 * <p>
 * 你可以从中选出任意数量的列并翻转其上的 每个 单元格。（即翻转后，单元格的值从 0 变成 1，或者从 1 变为 0 。）
 * <p>
 * 返回 经过一些翻转后，行与行之间所有值都相等的最大行数 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[0,1],[1,1]]
 * 输出：1
 * 解释：不进行翻转，有 1 行所有值都相等。
 * 示例 2：
 * <p>
 * 输入：matrix = [[0,1],[1,0]]
 * 输出：2
 * 解释：翻转第一列的值之后，这两行都由相等的值组成。
 * 示例 3：
 * <p>
 * 输入：matrix = [[0,0,0],[0,0,1],[1,1,0]]
 * 输出：2
 * 解释：翻转前两列的值之后，后两行由相等的值组成。
 *  
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] == 0 或 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/flip-columns-for-maximum-number-of-equal-rows
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxEqualRowsAfterFlips {

    /**
     * 0, 1, 0
     * 1, 0, 1 本质相同两行
     * => 第一列为1的，本行全部取反
     * 0, 1, 0
     * 0, 1, 0
     *
     * 那么问题变成行相同的最大数量
     * @param matrix
     * @return
     */
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix[0].length;
        Map<String, Integer> map = new HashMap<>();
        for (int[] ints : matrix) {
            char[] temp = new char[n];
            for (int j = 0; j < n; j++) {
                temp[j] = (char) ('0' + (ints[j] ^ ints[0]));
            }
            String key = new String(temp);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int ans = 0;
        for (Integer value : map.values()) {
            ans = Math.max(ans, value);
        }
        return ans;
    }
}

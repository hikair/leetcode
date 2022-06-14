package com.arr.middle;

/**
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,4,7,5,3,6,8,9]
 * 示例 2：
 * <p>
 * 输入：mat = [[1,2],[3,4]]
 * 输出：[1,2,3,4]
 *  
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 10^4
 * 1 <= m * n <= 10^4
 * -10^5 <= mat[i][j] <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/diagonal-traverse
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindDiagonalOrder {

    /**
     * 总共有m + n - 1条对角线
     * 偶数条对角线为从下往上
     * 奇数条对角线为从上往下
     * @param mat
     * @return
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] ans = new int[m * n];
        int index = 0;
        // i 为第几条对角线
        for (int i = 0; i < m + n; i++) {
            if (i % 2 == 0) {
                int x = i < m ? i : m - 1;
                int y = i < m ? 0 : i - m + 1;
                while (x >= 0 && y < n) {
                    ans[index++] = mat[x][y];
                    x--;
                    y++;
                }
            } else {
                int x = i < n ? 0 : i - n + 1;
                int y = i < n ? i : n - 1;
                while(x < m && y >= 0) {
                    ans[index++] = mat[x][y];
                    x++;
                    y--;
                }
            }
        }
        return ans;
    }
}

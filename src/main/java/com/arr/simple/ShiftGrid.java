package com.arr.simple;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 * <p>
 * 每次「迁移」操作将会引发下述活动：
 * <p>
 * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 * 请你返回 k 次迁移操作后最终得到的 二维网格。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[9,1,2],[3,4,5],[6,7,8]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * 输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 * 示例 3：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 * 输出：[[1,2,3],[4,5,6],[7,8,9]]
 *  
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 50
 * 1 <= n <= 50
 * -1000 <= grid[i][j] <= 1000
 * 0 <= k <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shift-2d-grid
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShiftGrid {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        for (int i = 0; i < k; i++) {
            shiftGrid(grid);
        }
        return Arrays.stream(grid).map(e -> Arrays.stream(e).boxed().collect(Collectors.toList())).collect(Collectors.toList());
    }

    private void shiftGrid(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        for (int i = col - 1; i > 0; i--) {
            for (int j = 0; j < row; j++) {
                change(grid, j, i, j, i - 1);
            }
        }
        for (int i = row - 1; i > 0; i--) {
            change(grid, i, 0, i - 1, 0);
        }
    }

    private void change(int[][] grid, int x1, int y1, int x2, int y2) {
        int t = grid[x1][y1];
        grid[x1][y1] = grid[x2][y2];
        grid[x2][y2] = t;
    }
}

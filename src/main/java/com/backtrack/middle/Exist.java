package com.backtrack.middle;

/**
 * 79. 单词搜索
 * <p>
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 *  
 * <p>
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Exist {

    public static final int[][] X = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};


    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check(board, visited, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, String word, int i, int j, int k) {
        if (board[i][j] != word.charAt(k)) {
            return false;
        }
        if (word.length() == k + 1) {
            return true;
        }
        visited[i][j] = true;
        for (int[] x : X) {
            int newI = i + x[0], newJ = j + x[1];
            if (newI < 0 || newI >= board.length || newJ < 0 || newJ >= board[0].length || visited[newI][newJ]) {
                continue;
            }
            if (check(board, visited, word, newI, newJ, k + 1)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}

package com.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParenthesis {

    /**
     * 当需要n对括号时，可以把一对括号当作基底，()，称之为E
     * 那么剩下n - 1对括号，可以在E的里面，也可以在E的右侧
     * 以n = 4为例
     * E里面的括号数量， E右侧的括号数量
     * 0, 3
     * 1, 2
     * 2, 1
     * 3, 0
     * 然后只需要求0个括号的所有情况，1个括号的所有情况，...n - 1个括号的所有情况，它们的排列组合
     * dp[n] 表示括号数为n时，所有有效的括号组合
     * dp[n] = dp[0] * dp[n - 1] + dp[1] * dp[n - 2] + ... + dp[n - 1] * dp[0]
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        ArrayList<String>[] dp = new ArrayList[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new ArrayList<>();
        }
        dp[0].add("");
        dp[1].add("()");
        for (int i = 2; i < n + 1; i++) {
            // 遍历E里面括号个数的情况
            for (int j = 0; j < i; j++) {
                // E里面括号个数为j个
                for (String inner : dp[j]) {
                    // E右侧括号为 i - j - 1个
                    for (String outer : dp[i - j - 1]) {
                        dp[i].add(String.format("(%s)%s", inner, outer));
                    }
                }
            }
        }
        return dp[n];
    }
}

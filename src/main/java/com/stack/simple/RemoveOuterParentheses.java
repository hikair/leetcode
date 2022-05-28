package com.stack.simple;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 有效括号字符串为空 ""、"(" + A + ")" 或 A + B ，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
 *
 * 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * 如果有效字符串 s 非空，且不存在将其拆分为 s = A + B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 *
 * 给出一个非空有效字符串 s，考虑将其进行原语化分解，使得：s = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 *
 * 对 s 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 s 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * 示例 2：
 *
 * 输入：s = "(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 * 示例 3：
 *
 * 输入：s = "()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * s[i] 为 '(' 或 ')'
 * s 是一个有效括号字符串
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-outermost-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveOuterParentheses {

    public String removeOuterParentheses(String s) {
        Deque<Character> queue = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c == ')') {
                queue.pollLast();
            }
            if (!queue.isEmpty()) {
                ans.append(c);
            }
            if (c == '(') {
                queue.addLast(c);
            }
        }
        return ans.toString();
    }

    public String removeOuterParentheses2(String s) {
        StringBuilder ans = new StringBuilder();
        char[] cs = s.toCharArray();
        int l = 0, r = 0, size = cs.length;
        int flag = 0;
        while(r < size) {
            if (cs[r] == '(') {
                flag++;
            } else {
                flag--;
            }
            if (flag == 0) {
                ans.append(s, l + 1, r);
                l = r + 1;
            }
            r++;
        }
        return ans.toString();
    }
}

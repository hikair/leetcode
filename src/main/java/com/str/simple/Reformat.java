package com.str.simple;

/**
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 * <p>
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 * <p>
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "a0b1c2"
 * 输出："0a1b2c"
 * 解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
 * 示例 2：
 * <p>
 * 输入：s = "leetcode"
 * 输出：""
 * 解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
 * 示例 3：
 * <p>
 * 输入：s = "1229857369"
 * 输出：""
 * 解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
 * 示例 4：
 * <p>
 * 输入：s = "covid2019"
 * 输出："c2o0v1i9d"
 * 示例 5：
 * <p>
 * 输入：s = "ab123"
 * 输出："1a2b3"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 500
 * s 仅由小写英文字母和/或数字组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reformat-the-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Reformat {

    public String reformat(String s) {
        char[] cs = s.toCharArray();
        int s1 = 0, n = s.length();
        for (char c : cs) {
            if (Character.isDigit(c)) {
                s1++;
            }
        }
        int s2 = n - s1;
        if (Math.abs(s1 - s2) > 1) {
            return "";
        }
        boolean flag = s1 > s2;
        // flag为true，0, 2, 4,.. 偶数位为数字，1, 3, 5,...奇数位为字母
        // flag为false，0, 2, 4,.. 偶数位为字母，1, 3, 5,...奇数位为数字
        for (int i = 0, j = 1; i < n; i += 2) {
            if (Character.isDigit(cs[i]) != flag) {
                while (Character.isDigit(cs[j]) != flag) {
                    j += 2;
                }
                swap(cs, i, j);
            }
        }
        return new String(cs);
    }

    private void swap(char[] cs, int i, int j) {
        char c = cs[i];
        cs[i] = cs[j];
        cs[j] = c;
    }
}

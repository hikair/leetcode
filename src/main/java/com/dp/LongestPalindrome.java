package com.dp;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome {

    /**
     * 中心扩散法
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int left, right;
        char[] chars = s.toCharArray();

        int rl = 0;
        int rr = 0;

        for (int i = 0; i < chars.length; i++) {
            left = right = i;
            while(left > 0 && chars[left - 1] == chars[i]) {
                left--;
            }
            while(right < s.length() - 1 && chars[right + 1] == chars[i]) {
                right++;
            }
            while(left >= 0 && right < s.length() && chars[left] == chars[right]) {
                left--;
                right++;
            }
            if (right - left > rr - rl) {
                rl = left;
                rr = right;
            }
        }
        return s.substring(rl + 1, rr);
    }

    /**
     * 动态规划
     * 对于[l, r]，如果[l + 1, r - 1]是回文数且chars[l] == chars[j]那么[l, r]也是回文数
     * dp[l][r] = dp[l + 1][r - 1] && chars[l] == chars[r]
     * 思路：以步长2开始，遍历所有长度为2的字符串，然后以3为步长...
     * 边界：所有长度为1的都是回文，长度为2的判断字符是否相等
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        int rl = 0, rr = 0;
        for (int len = 2; len <= length; len++) {
            for (int i = 0; i < length; i++) {
                int j = i + len - 1;
                if (j >= length) {
                    break;
                }
                if (len == 2) {
                    dp[i][j] = chars[i] == chars[j];
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && (chars[i] == chars[j]);
                }
                if (dp[i][j] && (len > rr - rl)) {
                    rl = i;
                    rr = j;
                }
            }
        }
        return s.substring(rl, rr + 1);
    }
}

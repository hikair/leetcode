package com.dp.middle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 把字符串 s 看作是 “abcdefghijklmnopqrstuvwxyz” 的无限环绕字符串，所以 s 看起来是这样的：
 *
 * "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd...." . 
 * 现在给定另一个字符串 p 。返回 s 中 唯一 的 p 的 非空子串 的数量 。 
 *
 *  
 *
 * 示例 1:
 *
 * 输入: p = "a"
 * 输出: 1
 * 解释: 字符串 s 中只有一个"a"子字符。
 * 示例 2:
 *
 * 输入: p = "cac"
 * 输出: 2
 * 解释: 字符串 s 中的字符串“cac”只有两个子串“a”、“c”。.
 * 示例 3:
 *
 * 输入: p = "zab"
 * 输出: 6
 * 解释: 在字符串 s 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。
 *  
 *
 * 提示:
 *
 * 1 <= p.length <= 10^5
 * p 由小写英文字母构成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/unique-substrings-in-wraparound-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindSubstringInWraproundString {

    /**
     * dp[x]表示以x结尾的字串最长长度，那么所求答案就是所有dp之和
     * @param p
     * @return
     */
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        char[] cs = p.toCharArray();
        int n = cs.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && (cs[i] - cs[i - 1] + 26) % 26 == 1) {
                count++;
            } else {
                count = 1;
            }
            dp[cs[i] - 'a'] = Math.max(dp[cs[i] - 'a'], count);
        }
        return Arrays.stream(dp).sum();
    }

    /**
     * 超时
     * @param p
     * @return
     */
    public int findSubstringInWraproundString2(String p) {
        char[] cs = p.toCharArray();
        int n = cs.length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(String.valueOf(cs[i]));
            for (int j = i; j > 0; j--) {
                if (cs[j] - cs[j - 1] != 1 && !(cs[j] == 'a' && cs[j - 1] == 'z')) {
                    break;
                }
                set.add(String.valueOf(cs, j - 1, i - j + 2));
            }
        }
        return set.size();
    }
}

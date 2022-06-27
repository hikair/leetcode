package com.twopointers.middle;

import java.util.Arrays;

/**
 * 给定字符串列表 strs ，返回其中 最长的特殊序列 。如果最长特殊序列不存在，返回 -1 。
 * <p>
 * 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。
 * <p>
 *  s 的 子序列可以通过删去字符串 s 中的某些字符实现。
 * <p>
 * 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。"aebdc"的子序列还包括"aebdc"、 "aeb" 和 "" (空字符串)。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: strs = ["aba","cdc","eae"]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: strs = ["aaa","aaa","aa"]
 * 输出: -1
 *  
 * <p>
 * 提示:
 * <p>
 * 2 <= strs.length <= 50
 * 1 <= strs[i].length <= 10
 * strs[i] 只包含小写英文字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-uncommon-subsequence-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindLUSlength {

    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (o1, o2) -> o2.length() - o1.length());
        for (int i = 0; i < strs.length; i++) {
            if (!isSub(strs, i)) {
                return strs[i].length();
            }
        }
        return -1;
    }

    private boolean isSub(String[] strs, int index) {
        for (int i =  0; i < strs.length; i++) {
            if (i == index) {
                continue;
            }
            if (strs[i].length() < strs[index].length()) {
                return false;
            }
            if (isSub(strs[index], strs[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean isSub(String s1, String s2) {
        int i = 0, j = 0;
        while(i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s1.length();
    }
}

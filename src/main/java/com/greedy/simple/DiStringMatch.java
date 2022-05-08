package com.greedy.simple;

/**
 * 由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
 *
 * 如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I' 
 * 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D' 
 * 给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "IDID"
 * 输出：[0,4,1,3,2]
 * 示例 2：
 *
 * 输入：s = "III"
 * 输出：[0,1,2,3]
 * 示例 3：
 *
 * 输入：s = "DDI"
 * 输出：[3,2,0,1]
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * s 只包含字符 "I" 或 "D"
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/di-string-match
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DiStringMatch {

    /**
     * 贪心算法
     * 读取s的第一个字符，如果是'I'，令第一个元素为0，那么下个元素必然比0大，如果是'D'，令第一个元素为n，则下一个元素必然比n小
     * 在读取s的第二个字符，此时问题规模变小，如果是'I'，令第二个元素为1，那么下个元素必然比1大，如果是'D'，令第一个元素为n - 1，则下一个元素必然比n - 1小
     * @param s
     * @return
     */
    public int[] diStringMatch(String s) {
        int n = s.length(), low = 0, high = n;
        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ans[i] = s.charAt(i) == 'I' ? low++ : high--;
        }
        ans[n] = low;
        return ans;
    }
}

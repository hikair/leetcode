package com.xor.middle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1177. 构建回文串检测
 * <p>
 * 给你一个字符串 s，请你对 s 的子串进行检测。
 * <p>
 * 每次检测，待检子串都可以表示为 queries[i] = [left, right, k]。我们可以 重新排列 子串 s[left], ..., s[right]，并从中选择 最多 k 项替换成任何小写英文字母。 
 * <p>
 * 如果在上述检测过程中，子串可以变成回文形式的字符串，那么检测结果为 true，否则结果为 false。
 * <p>
 * 返回答案数组 answer[]，其中 answer[i] 是第 i 个待检子串 queries[i] 的检测结果。
 * <p>
 * 注意：在替换时，子串中的每个字母都必须作为 独立的 项进行计数，也就是说，如果 s[left..right] = "aaa" 且 k = 2，我们只能替换其中的两个字母。（另外，任何检测都不会修改原始字符串 s，可以认为每次检测都是独立的）
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
 * 输出：[true,false,false,true,true]
 * 解释：
 * queries[0] : 子串 = "d"，回文。
 * queries[1] : 子串 = "bc"，不是回文。
 * queries[2] : 子串 = "abcd"，只替换 1 个字符是变不成回文串的。
 * queries[3] : 子串 = "abcd"，可以变成回文的 "abba"。 也可以变成 "baab"，先重新排序变成 "bacd"，然后把 "cd" 替换为 "ab"。
 * queries[4] : 子串 = "abcda"，可以变成回文的 "abcba"。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, queries.length <= 10^5
 * 0 <= queries[i][0] <= queries[i][1] < s.length
 * 0 <= queries[i][2] <= s.length
 * s 中只有小写英文字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/can-make-palindrome-from-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanMakePaliQueries {

    /**
     * 可以自由排序，那么就可以把字母数相同的消掉
     * 前缀和异或，s中每个字母可以用1 << s[i] - 'a'表示
     * 相同为0，不同为1
     * s[i]表示[0, i]中不同字母
     * s[l], s[r]
     * s[l] ^ s[r] 中 1的个数就是不同字母的数量t，只要k >= t / 2就是满足题目条件的
     *
     * @param s
     * @param queries
     * @return
     */
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        int[] count = new int[n + 1];
        for (int i = 0; i < n; i++) {
            count[i + 1] = count[i] ^ (1 << s.charAt(i) - 'a');
        }
        return Arrays.stream(queries).map(q -> q[2] >= Integer.bitCount(count[q[0]] ^ count[q[1] + 1]) / 2).collect(Collectors.toList());
    }
}

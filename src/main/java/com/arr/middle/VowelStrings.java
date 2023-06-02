package com.arr.middle;

/**
 * 2559. 统计范围内的元音字符串数
 * <p>
 * 给你一个下标从 0 开始的字符串数组 words 以及一个二维整数数组 queries 。
 * <p>
 * 每个查询 queries[i] = [li, ri] 会要求我们统计在 words 中下标在 li 到 ri 范围内（包含 这两个值）并且以元音开头和结尾的字符串的数目。
 * <p>
 * 返回一个整数数组，其中数组的第 i 个元素对应第 i 个查询的答案。
 * <p>
 * 注意：元音字母是 'a'、'e'、'i'、'o' 和 'u' 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
 * 输出：[2,3,0]
 * 解释：以元音开头和结尾的字符串是 "aba"、"ece"、"aa" 和 "e" 。
 * 查询 [0,2] 结果为 2（字符串 "aba" 和 "ece"）。
 * 查询 [1,4] 结果为 3（字符串 "ece"、"aa"、"e"）。
 * 查询 [1,1] 结果为 0 。
 * 返回结果 [2,3,0] 。
 * 示例 2：
 * <p>
 * 输入：words = ["a","e","i"], queries = [[0,2],[0,1],[2,2]]
 * 输出：[3,2,1]
 * 解释：每个字符串都满足这一条件，所以返回 [3,2,1] 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 10^5
 * 1 <= words[i].length <= 40
 * words[i] 仅由小写英文字母组成
 * sum(words[i].length) <= 3 * 10^5
 * 1 <= queries.length <= 105
 * 0 <= queries[j][0] <= queries[j][1] < words.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-vowel-strings-in-ranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class VowelStrings {

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] temp = new int[words.length];
        temp[0] = isVowel(words[0]) ? 1 : 0;
        for (int i = 1; i < words.length; i++) {
            temp[i] = temp[i - 1] + (isVowel(words[i]) ? 1 : 0);
        }
        for (int i = 0; i < queries.length; i++) {
            ans[i] = temp[queries[i][1]] - (queries[i][0] == 0 ? 0 : temp[queries[i][0] - 1]);
        }
        return ans;
    }

    private boolean isVowel(String str) {
        if (str.length() == 1) {
            return isVowel(str.charAt(0));
        }
        return isVowel(str.charAt(0)) && isVowel(str.charAt(str.length() - 1));
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

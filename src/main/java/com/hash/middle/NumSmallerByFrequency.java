package com.hash.middle;

import java.util.TreeMap;

/**
 * 1170. 比较字符串最小字母出现频次
 * <p>
 * 定义一个函数 f(s)，统计 s  中（按字典序比较）最小字母的出现频次 ，其中 s 是一个非空字符串。
 * <p>
 * 例如，若 s = "dcce"，那么 f(s) = 2，因为字典序最小字母是 "c"，它出现了 2 次。
 * <p>
 * 现在，给你两个字符串数组待查表 queries 和词汇表 words 。对于每次查询 queries[i] ，需统计 words 中满足 f(queries[i]) < f(W) 的 词的数目 ，W 表示词汇表 words 中的每个词。
 * <p>
 * 请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是第 i 次查询的结果。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：queries = ["cbd"], words = ["zaaaz"]
 * 输出：[1]
 * 解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
 * 示例 2：
 * <p>
 * 输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * 输出：[1,2]
 * 解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= queries.length <= 2000
 * 1 <= words.length <= 2000
 * 1 <= queries[i].length, words[i].length <= 10
 * queries[i][j]、words[i][j] 都由小写英文字母组成
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/compare-strings-by-frequency-of-the-smallest-character
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumSmallerByFrequency {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (String word : words) {
            int f = f(word);
            map.put(f, map.getOrDefault(f, 0) + 1);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = map.tailMap(f(queries[i]) + 1).values().stream().mapToInt(e -> e).sum();
        }
        return ans;
    }

    public int f(String str) {
        char[] cs = str.toCharArray();
        int n = 1;
        char c = cs[0];
        for (int i = 1; i < cs.length; i++) {
            if (cs[i] - c < 0) {
                n = 1;
                c = cs[i];
            } else if (cs[i] == c) {
                n++;
            }
        }
        return n;
    }
}

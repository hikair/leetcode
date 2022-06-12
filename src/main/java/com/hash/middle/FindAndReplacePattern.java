package com.hash.middle;

import java.util.*;

/**
 * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
 * <p>
 * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
 * <p>
 * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
 * <p>
 * 返回 words 中与给定模式匹配的单词列表。
 * <p>
 * 你可以按任何顺序返回答案。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * 输出：["mee","aqq"]
 * 解释：
 * "mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
 * "ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
 * 因为 a 和 b 映射到同一个字母。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 50
 * 1 <= pattern.length = words[i].length <= 20
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-and-replace-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindAndReplacePattern {

    /**
     * cbc 和 abb不匹配！！
     * @param words
     * @param pattern
     * @return
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        int[] map = new int[26], vis = new int[26];
        char[] cs = pattern.toCharArray();
        for (String word : words) {
            Arrays.fill(map, -1);
            Arrays.fill(vis, 0);
            boolean match = true;
            for (int i = 0; i < cs.length; i++) {
                int pc = cs[i] - 'a';
                int wc = word.charAt(i) - 'a';
                if (map[pc] == -1 && vis[wc] == 0) {
                    map[pc] = wc;
                    vis[wc] = 1;
                    continue;
                }
                if (map[pc] != wc) {
                    match = false;
                    break;
                }
            }
            if (match) {
                ans.add(word);
            }
        }
        return ans;
    }
}

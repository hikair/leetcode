package com.hash.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 2451. 差值数组不同的字符串
 * <p>
 * 给你一个字符串数组 words ，每一个字符串长度都相同，令所有字符串的长度都为 n 。
 * <p>
 * 每个字符串 words[i] 可以被转化为一个长度为 n - 1 的 差值整数数组 difference[i] ，其中对于 0 <= j <= n - 2 有 difference[i][j] = words[i][j+1] - words[i][j] 。注意两个字母的差值定义为它们在字母表中 位置 之差，也就是说 'a' 的位置是 0 ，'b' 的位置是 1 ，'z' 的位置是 25 。
 * <p>
 * 比方说，字符串 "acb" 的差值整数数组是 [2 - 0, 1 - 2] = [2, -1] 。
 * words 中所有字符串 除了一个字符串以外 ，其他字符串的差值整数数组都相同。你需要找到那个不同的字符串。
 * <p>
 * 请你返回 words中 差值整数数组 不同的字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["adc","wzy","abc"]
 * 输出："abc"
 * 解释：
 * - "adc" 的差值整数数组是 [3 - 0, 2 - 3] = [3, -1] 。
 * - "wzy" 的差值整数数组是 [25 - 22, 24 - 25]= [3, -1] 。
 * - "abc" 的差值整数数组是 [1 - 0, 2 - 1] = [1, 1] 。
 * 不同的数组是 [1, 1]，所以返回对应的字符串，"abc"。
 * 示例 2：
 * <p>
 * 输入：words = ["aaa","bob","ccc","ddd"]
 * 输出："bob"
 * 解释：除了 "bob" 的差值整数数组是 [13, -13] 以外，其他字符串的差值整数数组都是 [0, 0] 。
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= words.length <= 100
 * n == words[i].length
 * 2 <= n <= 20
 * words[i] 只含有小写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/odd-string-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OddString {

    public String oddString(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, String> nameMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            char[] cs = words[i].toCharArray();
            for (int j = 1; j < cs.length; j++) {
                sb.append(cs[j] - cs[j - 1]).append(",");
            }
            nameMap.put(sb.toString(), words[i]);
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            if (map.size() > 1 && i > 1) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (entry.getValue() == 1) {
                        return nameMap.get(entry.getKey());
                    }
                }
            }
        }
        return null;
    }
}

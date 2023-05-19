package com.backtrack.middle;

import java.util.*;

/**
 * 1079. 活字印刷
 * <p>
 * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 * <p>
 * 注意：本题中，每个活字字模只能使用一次。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："AAB"
 * 输出：8
 * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 * 示例 2：
 * <p>
 * 输入："AAABBC"
 * 输出：188
 * 示例 3：
 * <p>
 * 输入："V"
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= tiles.length <= 7
 * tiles 由大写英文字母组成
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/letter-tile-possibilities
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumTilePossibilities {

    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tiles.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return dfs(tiles.length(), map, map.keySet()) - 1;
    }

    public int dfs(int i, Map<Character, Integer> map, Set<Character> set) {
        if (i == 0) {
            return 1;
        }
        int res = 1;
        for (Character c : set) {
            if (map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
                res += dfs(i - 1, map, set);
                map.put(c, map.get(c) + 1);
            }
        }
        return res;
    }
}

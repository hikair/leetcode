package com.backtrack.middle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
 * <p>
 * 如果你能使这个正方形，则返回 true ，否则返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: matchsticks = [1,1,2,2,2]
 * 输出: true
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * 示例 2:
 * <p>
 * 输入: matchsticks = [3,3,3,3,4]
 * 输出: false
 * 解释: 不能用所有火柴拼成一个正方形。
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= matchsticks.length <= 15
 * 1 <= matchsticks[i] <= 10^8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/matchsticks-to-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Makesquare {

    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) {
            return false;
        }
        int len = sum / 4;
        List<Integer> list = Arrays.stream(matchsticks).boxed().sorted(((o1, o2) -> o2 - o1)).collect(Collectors.toList());
        if (list.get(0) > len) {
            return false;
        }
        return backtrack(list, len, 0, new int[4]);
    }

    private boolean backtrack(List<Integer> list, int target, int index, int[] lens) {
        if (index == list.size()) {
            return lens[0] == target && lens[1] == lens[0] && lens[2] == lens[1];
        }
        for (int i = 0; i < 4; i++) {
            if (lens[i] + list.get(index) > target) {
                continue;
            }
            lens[i] += list.get(index);
            if (backtrack(list, target, index + 1, lens)) {
                return true;
            }
            lens[i] -= list.get(index);
        }
        return false;
    }
}

package com.hash.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 * <p>
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 * <p>
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 * <p>
 * 请你返回「表现良好时间段」的最大长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：hours = [9,9,6,0,6,6,9]
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 * 示例 2：
 * <p>
 * 输入：hours = [6,6,6]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= hours.length <= 10^4
 * 0 <= hours[i] <= 16
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-well-performing-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestWPI {

    /**
     * 可以把大于8小时设置1，不大于8小时设置为-1
     * [9, 9, 6, 0, 6, 6, 9] -> [1, 1, -1, -1, -1, -1, 1]
     * 计算前缀和s [1, 2, 1, 0, -1, -2, -1]
     * [6, 6, 9, 9, 6, 9, 6] -> [-1, -1, 1, 1, -1, 1, -1]
     * 计算前缀和s [-1, -2, -1, 0, -1, 0, -1]
     * 如果s[i] > 0 那么 i + 1 是 表现良好的时间段
     * 如果s[i] < 0 要想有表现良好时间段，就一定要有一个j，满足j < i, s[i] - s[j] > 0
     * 想要最大长度的表现良好的时间段，只需要找到第一个j,满足 s[i] = s[j] - 1
     * @param hours
     * @return
     */
    public int longestWPI(int[] hours) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int sum = 0, result = 0;
        for (int i = 0; i < hours.length; i++) {
            sum += hours[i] > 8 ? 1 : -1;
            if (sum > 0) {
                result = Math.max(result, i + 1);
            } else {
                if (indexMap.containsKey(sum - 1)) {
                    result = Math.max(result, i - indexMap.get(sum - 1));
                }
            }
            if (!indexMap.containsKey(sum)) {
                indexMap.put(sum, i);
            }
        }
        return result;
    }
}

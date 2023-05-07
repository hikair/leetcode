package com.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 1010. 总持续时间可被 60 整除的歌曲
 * <p>
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * <p>
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望下标数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：time = [30,20,150,100,40]
 * 输出：3
 * 解释：这三对的总持续时间可被 60 整除：
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 * 示例 2：
 * <p>
 * 输入：time = [60,60,60]
 * 输出：3
 * 解释：所有三对的总持续时间都是 120，可以被 60 整除。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= time.length <= 6 * 10^4
 * 1 <= time[i] <= 500
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/pairs-of-songs-with-total-durations-divisible-by-60
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumPairsDivisibleBy60 {

    public int numPairsDivisibleBy60(int[] time) {
        int[] arr = new int[60];
        long count = 0;
        for (int t : time) {
            arr[t % 60]++;
        }
        for (int i = 1; i < 30; i++) {
            count += (long) arr[i] * arr[60 - i];
        }
        count += (long) arr[0] * (arr[0] - 1) / 2 + (long) arr[30] * (arr[30] - 1) / 2;
        return (int) count;
    }

    public int numPairsDivisibleBy602(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int t : time) {
            int m = t % 60;
            // 查看有没有配对的
            count += map.getOrDefault((60 - m) % 60, 0);
            map.put(m, map.getOrDefault(m, 0) + 1);
        }
        return count;
    }
}

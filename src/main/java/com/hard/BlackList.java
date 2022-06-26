package com.hard;

import java.util.*;

/**
 * 给定一个整数 n 和一个 无重复 黑名单整数数组 blacklist 。设计一种算法，从 [0, n - 1] 范围内的任意整数中选取一个 未加入 黑名单 blacklist 的整数。任何在上述范围内且不在黑名单 blacklist 中的整数都应该有 同等的可能性 被返回。
 * <p>
 * 优化你的算法，使它最小化调用语言 内置 随机函数的次数。
 * <p>
 * 实现 Solution 类:
 * <p>
 * Solution(int n, int[] blacklist) 初始化整数 n 和被加入黑名单 blacklist 的整数
 * int pick() 返回一个范围为 [0, n - 1] 且不在黑名单 blacklist 中的随机整数
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入
 * ["Solution", "pick", "pick", "pick", "pick", "pick", "pick", "pick"]
 * [[7, [2, 3, 5]], [], [], [], [], [], [], []]
 * 输出
 * [null, 0, 4, 1, 6, 1, 0, 4]
 * <p>
 * 解释
 * Solution solution = new Solution(7, [2, 3, 5]);
 * solution.pick(); // 返回0，任何[0,1,4,6]的整数都可以。注意，对于每一个pick的调用，
 * // 0、1、4和6的返回概率必须相等(即概率为1/4)。
 * solution.pick(); // 返回 4
 * solution.pick(); // 返回 1
 * solution.pick(); // 返回 6
 * solution.pick(); // 返回 1
 * solution.pick(); // 返回 0
 * solution.pick(); // 返回 4
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 10^9
 * 0 <= blacklist.length <= min(10^5, n - 1)
 * 0 <= blacklist[i] < n
 * blacklist 中所有值都 不同
 *  pick 最多被调用 2 * 10^4 次
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/random-pick-with-blacklist
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BlackList {

    int whiteNum;
    Random random;
    Map<Integer, Integer> map;

    public BlackList(int n, int[] blacklist) {
        random = new Random();
        map = new HashMap<>();
        int m = blacklist.length;
        whiteNum = n - m;
        Set<Integer> rightBlack = new HashSet<>();
        for (int value : blacklist) {
            if (value >= whiteNum) {
                rightBlack.add(value);
            }
        }
        int t = whiteNum;
        for (int value : blacklist) {
            if (value < whiteNum) {
                while(rightBlack.contains(t)) {
                    t++;
                }
                map.put(value, t);
                t++;
            }
        }
    }

    public int pick() {
        int x = random.nextInt(whiteNum);
        return map.getOrDefault(x, x);
    }
}

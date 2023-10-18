package com.queue.middle;

import java.util.PriorityQueue;

/**
 * 2530. 执行 K 次操作后的最大分数
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。你的 起始分数 为 0 。
 * <p>
 * 在一步 操作 中：
 * <p>
 * 选出一个满足 0 <= i < nums.length 的下标 i ，
 * 将你的 分数 增加 nums[i] ，并且
 * 将 nums[i] 替换为 ceil(nums[i] / 3) 。
 * 返回在 恰好 执行 k 次操作后，你可能获得的最大分数。
 * <p>
 * 向上取整函数 ceil(val) 的结果是大于或等于 val 的最小整数。
 * <p>
 * https://leetcode.cn/problems/maximal-score-after-applying-k-operations/description
 */
public class MaxKelements {

    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            queue.add(num);
        }
        long ans = 0;
        for (int i = 0; i < k; i++) {
            Integer t = queue.poll();
            ans += t;
            queue.add((t + 2) / 3);
        }
        return ans;
    }
}

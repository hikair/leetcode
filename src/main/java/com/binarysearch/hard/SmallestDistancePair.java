package com.binarysearch.hard;

import java.util.Arrays;

/**
 * 数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length 。返回 所有数对距离中 第 k 小的数对距离。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,1], k = 1
 * 输出：0
 * 解释：数对和对应的距离如下：
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * 距离第 1 小的数对是 (1,1) ，距离为 0 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：nums = [1,6,1], k = 3
 * 输出：5
 *  
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 2 <= n <= 10^4
 * 0 <= nums[i] <= 10^6
 * 1 <= k <= n * (n - 1) / 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-k-th-smallest-pair-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SmallestDistancePair {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, r = nums[n - 1] - nums[0];
        while(l <= r) {
            // 数对距离
            int mid = l + (r - l) / 2;
            // 小于等于当前数对距离的对数
            int count = 0;
            for (int i = 0; i < n; i++) {
                int j = binarySearch(nums, i, mid);
                count += i - j;
            }
            if (count >= k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     * 查找数对距离不小于len的最小下标
     * @param nums
     * @param end 数对右节点
     * @param len 数对距离
     * @return
     */
    public int binarySearch(int[] nums, int end, int len) {
        int l = 0, r = end;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if (nums[end] - nums[mid] > len) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}

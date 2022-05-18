package com.arr.middle;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。
 *
 * 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：
 * 只需要两步操作（每步操作指南使一个元素加 1 或减 1）：
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * 示例 2：
 *
 * 输入：nums = [1,10,2,9]
 * 输出：16
 *  
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinMoves2 {

    /**
     * 对于任一升序序列
     * [0, 1, 2, 6, 8]
     * 首尾(0, 8)，变化步骤固定为8，取值为[0, 8]
     * 再看(1, 6)，变化步骤固定为5，取值为[1, 6]
     * 再看(2), 无需变化，取值[2]，取他们的交集，答案就是中位数下标的那个数作为基准，步数最少
     * 对于偶数数组
     * 示例： [0, 1, 2, 6]
     *
     * 1、在 [0, 6] 任意找一个数，固定最小次数 6
     * 2、在 [1, 2] 任意找一个数，固定最小次数 1
     *
     * 中间数的选取条件为 [0, 6] 交集 [1, 2] = [1, 2]，即 1或2 都行，最小移动次数为 6+1 = 7
     * @param nums
     * @return
     */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        int ans = 0;
        for (int num : nums) {
            ans += Math.abs(mid - num);
        }
        return ans;
    }
}

package com.arr.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
 *
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[2,3]
 * 示例 2：
 *
 * 输入：nums = [1,1,2]
 * 输出：[1]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 10^5
 * 1 <= nums[i] <= n
 * nums 中的每个元素出现 一次 或 两次
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-duplicates-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindDuplicates {

    /**
     * 正负标记法
     * 对于数i，第一次遇到i将nums[nums[i] - 1]标为负数，第二次遇到时，判断它是不是负数，是的话表示重复了
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            int val = Math.abs(num);
            if (nums[val - 1] > 0) {
                nums[val - 1] = -nums[val - 1];
            } else {
                ans.add(val);
            }
        }
        return ans;
    }

    /**
     * 用个数组存储每个数出现的次数
     * 空间复杂度O(n)，不符合题目要求
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int[] arr = new int[nums.length + 1];
        for (int num : nums) {
            arr[num]++;
            if (arr[num] > 1) {
                ans.add(num);
            }
        }
        return ans;
    }
}

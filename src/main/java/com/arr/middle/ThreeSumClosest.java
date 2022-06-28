package com.arr.middle;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * <p>
 * 返回这三个数的和。
 * <p>
 * 假定每组输入只存在恰好一个解。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -10^4 <= target <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int k = n - 1;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int t;
                while (k > j && (t = nums[i] + nums[j] + nums[k] - target) > 0) {
                    if (Math.abs(ans) > Math.abs(t)) {
                        ans = t;
                    }
                    k--;
                }
                if (k == j) {
                    break;
                }
                t = nums[i] + nums[j] + nums[k] - target;
                if (t == 0) {
                    return target;
                }
                if (Math.abs(ans) > Math.abs(t)) {
                    ans = t;
                }
            }
        }
        return target + ans;
    }
}

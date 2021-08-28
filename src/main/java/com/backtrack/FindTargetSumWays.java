package com.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 *     例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 *
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 *
 * 示例 2：
 *
 * 输入：nums = [1], target = 1
 * 输出：1
 *
 *
 *
 * 提示：
 *
 *     1 <= nums.length <= 20
 *     0 <= nums[i] <= 1000
 *     0 <= sum(nums[i]) <= 1000
 *     -1000 <= target <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindTargetSumWays {

    int sum = 0, count = 0, deep = 0;

    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0);
        return count;
    }

    /**
     * 超时了！！！
     * @param nums
     * @param target
     * @param startIndex
     */
    public void backtrack(int[] nums, int target, int startIndex) {
        if(sum == target && deep == nums.length) {
            count++;
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            sum += nums[i];
            deep++;
            backtrack(nums, target, i + 1);
            deep--;
            sum -= 2 * nums[i];
            deep++;
            backtrack(nums, target, i + 1);
            sum += nums[i];
            deep--;
        }

    }

    public static void main(String[] args) {
        System.out.println(new FindTargetSumWays().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}

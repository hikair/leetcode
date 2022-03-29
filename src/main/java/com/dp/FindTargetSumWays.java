package com.dp;

/**
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
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
 * 示例 2：
 *
 * 输入：nums = [1], target = 1
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindTargetSumWays {

    /**
     * dp[i][j] 表示0~i能凑出j的情况的数量 即答案：dp[nums.length][target]
     * dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j + nums[i]] 即有多少种情况凑出上一个状态i-1，数量可以是j - nums[i] 也可以是 j + nums[i]
     * 因为要想达到最后一步，只要加上最后一个数或者减去最后一个数
     *
     * sum = nums[0] + ... + nums[nums.len - 1]
     * 按照题意  -sum <= target <= sum
     * 所以 dp定义大小时  dp[nums.length][2 * sum + 1] 因为数组下标不能为负，所以整体往右移动sum！！！
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // target若比nums所有元素加起来都大，就没有办法达到
        if(Math.abs(target) > sum) {
            return 0;
        }
        int len = nums.length;
        int t = 2 * sum + 1;
        int[][] dp = new int[len][t];

        if(nums[0] == 0) {
            // -0 或 +0
            dp[0][sum] = 2;
        }else {
            //dp[0][sum] = 0; 数组初始化默认就是0
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] = 1;
        }

        for (int i = 1; i < len; i++) {

            for (int j = 0; j < t; j++) {
                // 边界
                int l = (j - nums[i]) >= 0 ? j - nums[i] : 0;
                int r = (j + nums[i]) < t ? j + nums[i] : 0;
                dp[i][j] = dp[i - 1][l] + dp[i - 1][r];
            }
        }
        return dp[len - 1][sum + target];
    }

    public static void main(String[] args) {
        FindTargetSumWays obj = new FindTargetSumWays();
        System.out.println(obj.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }
}

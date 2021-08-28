package com.arr;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 *
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 *
 * 输入：nums = [-100000]
 * 输出：-100000
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 10^4
 * -10^5 <= nums[i] <= 10^5
 *
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSubArray {

    /**
     * 贪心算法
     * 思路：遍历数组，从前往后加，其sum值如果<0就舍弃，重新开始加
     * 每次加的过程中，用一个变量存最大值，并与当前加起来的值比较，取最大值
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int t = 0;
        for (int num : nums) {
            t += num;
            // 先判断大小
            max = Math.max(max, t);
            // 前边加起来负的不要，重新开始加
            if(t < 0) {
                t = 0;
            }
        }
        return max;
    }


    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {

        // f[x] 表示以nums[x]结尾的所有连续子数组中所有元素的和最大的值
        int[] f = new int[nums.length];
        // 转移方程  f[x] = Math.max(f[x-1] + nums[x], nums[x]);
        // 初始值
        f[0] = nums[0];

        // 定义一个临时变量，用来存f[x]里的最大值
        int maxVal = nums[0];

        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.max(f[i-1] + nums[i], nums[i]);
            maxVal = Math.max(maxVal, f[i]);
        }

        return maxVal;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int i = maxSubArray.maxSubArray2(new int[]{-2,1,-3,4,-1,2,1,-5,4}); //[4,-1,2,1]
        //int i = maxSubArray.maxSubArray2(new int[]{-2,-1});
        //int i = maxSubArray.maxSubArray(new int[]{-1,1,2,1});
        //int i = maxSubArray.maxSubArray(new int[]{-2,3,1,3});
        System.out.println(i);
    }
}

package com.arr;

/**
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 *
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *  
 *
 * 提示：
 *
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5 <= nums[i] <= 10 ^ 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckPossibility {

    /**
     * 有2次以上左边比右边大的情况，return false
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        int index = -1;

        if(nums.length < 3) {
            return true;
        }

        for (int i = 0; i < n - 1; i++) {
            if(nums[i] > nums[i+1]) {
                if(index >= 0) {
                    return false;
                }
                index = i;
            }
        }

        if(index == n - 2 || index == 0) {
            return true;
        }else {
            if(nums[index + 2] <= nums[index]) {
                return false;
            }

            if(nums[index - 1] > nums[index + 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CheckPossibility obj = new CheckPossibility();
/*        System.out.println(obj.checkPossibility(new int[]{2,4,1}));// true
        System.out.println(obj.checkPossibility(new int[]{2,4,1,1}));// false
        System.out.println(obj.checkPossibility(new int[]{4,2,1}));// false
        System.out.println(obj.checkPossibility(new int[]{3,1}));// true
        System.out.println(obj.checkPossibility(new int[]{5,7,1,8}));// true*/
        System.out.println(obj.checkPossibility(new int[]{-1,4,2,3}));// true
        System.out.println(obj.checkPossibility(new int[]{4,2,3}));// true
    }
}

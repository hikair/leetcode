package com.num;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 *
 * 提示：
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * -3,0,1,2
 * 1
 * 0
 */
public class ThreeSumCloest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        if(nums.length == 3) {
            return result;
        }
        // 先计算前三个值与目标值的相似度
        double a = result*1.0/target;
        for(int i=1;i<nums.length-2;i++) {
            int res = nums[i] + nums[i+1] + nums[i+2];
            double b = res*1.0/target;
            // 与前一个相似度比较。比较哪个更接近于1
            if(Math.abs(b-1)<=Math.abs(a-1)) {
                a = b;
                result = res;
            }else {
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {0,2,1,-3};
        ThreeSumCloest threeSumCloest = new ThreeSumCloest();
        int i = threeSumCloest.threeSumClosest(a, 1);
        System.out.println(i);
    }
}

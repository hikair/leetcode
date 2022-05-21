package com.hash.simple;

import java.util.*;

/**
 * 给你一个整数数组 nums ，该数组具有以下属性：
 *
 * nums.length == 2 * n.
 * nums 包含 n + 1 个 不同的 元素
 * nums 中恰有一个元素重复 n 次
 * 找出并返回重复了 n 次的那个元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [2,1,2,5,3,2]
 * 输出：2
 * 示例 3：
 *
 * 输入：nums = [5,1,5,2,5,3,5,4]
 * 输出：5
 *  
 *
 * 提示：
 *
 * 2 <= n <= 5000
 * nums.length == 2 * n
 * 0 <= nums[i] <= 10^4
 * nums 由 n + 1 个 不同的 元素组成，且其中一个元素恰好重复 n 次
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/n-repeated-element-in-size-2n-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RepeatedNTimes {

    /**
     * 随机选择
     * @param nums
     * @return
     */
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        Random random = new Random();
        while (true) {
            int a = random.nextInt(n), b = random.nextInt(n);
            if (a != b && nums[a] == nums[b]) {
                return nums[a];
            }
        }
    }

    /**
     * 数学
     * 给定数据有2n，其中某个数出现n次，这个数计做x
     * 理想情况下，x与x之间存在一个其他数字，当隔了2个数字时，例：x,a,b,x,c,d,x,...,x   长度为n + 2(n - 1)
     * 除了n=2时，必然会有两个x相邻的情况
     * 所以只需要判断相邻[1,3]以内坐标的值是否存在相等的情况
     * @param nums
     * @return
     */
    public int repeatedNTimes2(int[] nums) {
        int n = nums.length;
        for (int step = 1; step <= 3; step++) {
            for (int i = 0; i + step < n; i++) {
                if (nums[i] == nums[i + step]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    /**
     * hash
     * @param nums
     * @return
     */
    public int repeatedNTimes3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return 0;
    }
}

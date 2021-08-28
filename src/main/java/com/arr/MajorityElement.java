package com.arr;

import java.util.Arrays;

/**
 * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 * 示例 2：
 *
 * 输入：[3,2]
 * 输出：-1
 * 示例 3：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-majority-element-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MajorityElement {

    /**
     * Boyer-Moore 投票算法
     * 第一轮如果两个数不同，直接消除，如果存在某个数是众数，那么他一定会遗留下来。
     * 如果不存在，ex:1，2，3 会留下3 ，需要进行第二轮验证
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int candidate = -1;
        int count = 0;
        // 第一轮，消消乐
        for (int num : nums) {
            if(count == 0) {
                candidate = num;
            }
            if(candidate == num) {
                count++;
            }else {
                count--;
            }
        }
        // 第二轮，验证，避免偷鸡情况。ex:1，2，3
        count = 0;
        for (int num : nums) {
            if(candidate == num) {
                count++;
            }
        }
        return 2 * count > n ? candidate : -1;
    }

    public int majorityElement2(int[] nums) {
        int n = nums.length, sum = 1;
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                sum++;
                if(n / sum == 1) {
                    return nums[i];
                }
            }else {
                sum = 1;
            }
        }
        return n < 2 ? nums[0] : -1;
    }

    public static void main(String[] args) {
        MajorityElement obj = new MajorityElement();
        System.out.println(obj.majorityElement(new int[]{1,2,5,9,5,9,5,5,5}));
        System.out.println(obj.majorityElement(new int[]{3,2,3}));
        System.out.println(obj.majorityElement(new int[]{3}));
        System.out.println(obj.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}

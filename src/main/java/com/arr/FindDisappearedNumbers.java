package com.arr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * 示例 2：
 *
 * 输入：nums = [1,1]
 * 输出：[2]
 *  
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 10^5
 * 1 <= nums[i] <= n
 * 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[nums[i]]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if(arr[i] == 0) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        FindDisappearedNumbers obj = new FindDisappearedNumbers();
        System.out.println(obj.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(obj.findDisappearedNumbers(new int[]{1,1}));
    }
}

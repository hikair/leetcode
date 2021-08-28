package com.arr;

import java.util.*;

/**
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * 示例 2：
 *
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * 示例 3：
 *
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 *  
 *
 * 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThirdMax {

    /**
     * 排序加去重
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        int[] ints = Arrays.stream(nums).sorted().distinct().toArray();
        int n = ints.length;
        if(n < 3) {
            return ints[n - 1];
        }
        return ints[n - 3];
    }

    public int thirdMax2(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            set.add(nums[i]);
            if(set.size() == 3) {
                break;
            }
        }
        Object[] temp =  set.toArray();
        Arrays.sort(temp);
        int n = temp.length;
        if(n < 3) {
            return (int) temp[n - 1];
        }
        return (int) temp[0];
    }

    public int thirdMax3(int[] nums) {
        Arrays.sort(nums);
        SortedSet<Integer> set = new TreeSet();
        for (int i = nums.length - 1; i >= 0; i--) {
            set.add(nums[i]);
            if(set.size() == 3) {
                break;
            }
        }
        return set.size() < 3 ? set.last() : set.first();
    }

    public static void main(String[] args) {
        ThirdMax obj = new ThirdMax();
        System.out.println(obj.thirdMax3(new int[]{1,2,2,5,3,5}));//2
        System.out.println(obj.thirdMax3(new int[]{2,2,2,2,3}));//3
        System.out.println(obj.thirdMax3(new int[]{1,1,1}));//1
        System.out.println(obj.thirdMax3(new int[]{2,2,3,1}));//1
        System.out.println(obj.thirdMax3(new int[]{1,2}));//2
        System.out.println(obj.thirdMax3(new int[]{3,2,1}));//1
        System.out.println(obj.thirdMax3(new int[]{3}));//3

    }
}

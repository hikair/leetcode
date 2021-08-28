package com.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * 示例 2:
 *
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * nums[i] 不是 0 就是 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contiguous-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMaxLength {

    public int findMaxLength(int[] nums) {
        // dp[x] 表示nums 下标0...x，值为1的个数
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        // 记录最长长度
        int max = 0;

        int j = 1;
        while(j < nums.length) {
            for (int i = j; i < nums.length; i++) {
                dp[i] = dp[i-1] + nums[i];
                if(dp[i] == i+1-dp[i]) {
                    max = 2 * dp[i];
                }
            }
            j++;
        }


        return max;
    }

    /**
     * 把0当作-1，1当作1
     * 如果存在sum[i] = sum[j]，那么 nums[i] + ... + nums[j] = 0，即i到j有偶数对0和1
     * 原问题求解变为 j - i 的最大值
     * @param nums
     * @return
     */
    public int findMaxLength2(int[] nums) {
        // 最长长度
        int max = 0;
        int count = 0;
        // Key：value -> count：下标
        Map<Integer,Integer> map = new HashMap<>();
        // 默认放个0，-1  因为有可能全部数加起来刚好等于0，此时最长长度就是原数组长度 例：0，1，0，1
        map.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                count--;
            }else {
                count++;
            }
            if(map.containsKey(count)) {
                max = Math.max(max, i - map.get(count));
            }else {
                map.put(count, i);
            }
        }
        return max;
    }

    public int findMaxLength3(int[] nums) {
        int n = nums.length, max = 0;
        // 前缀和，1的个数
        int[] count1 = new int[n + 1];
        for (int i = 0; i < n; i++) {
            count1[i + 1] = count1[i] + nums[i];
        }
        // dif[n]表示0比1多0个的情况，即从num第一个元素开始就在此子数组中
        int[] dif = new int[2 * n + 1];
        for (int i = 1; i <= n; i++) {
            int idx = i - 2 * count1[i] + n;
            int pre = dif[idx];
            if (idx == n || pre != 0) {
                max = Math.max(max, i - pre);
            } else {
                dif[idx] = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        FindMaxLength obj = new FindMaxLength();
        System.out.println(obj.findMaxLength3(new int[]{0,0,1,0,0,0,1,1}));//6
        //System.out.println(obj.findMaxLength2(new int[]{0,1}));//2
    }
}

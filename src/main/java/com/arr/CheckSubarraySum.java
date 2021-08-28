package com.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 *
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [23,2,4,6,7], k = 6
 * 输出：true
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
 * 示例 2：
 *
 * 输入：nums = [23,2,6,4,7], k = 6
 * 输出：true
 * 解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
 * 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
 * 示例 3：
 *
 * 输入：nums = [23,2,6,4,7], k = 13
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^9
 * 0 <= sum(nums[i]) <= 2^31 - 1
 * 1 <= k <= 2^31 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckSubarraySum {

    /**
     * 超时
     * 子数组元素总和为 k 的倍数。
     * 根据余数性质的可减性  x / k = ...n    y / k = ...n
     * 则(x - y) / k = ...0
     * 原问题可化简为 (sum[i] - sum[j]) % k == 0 && j - i >= 2 即存在sum(nums[i],..,nums[j])是k的倍数
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] f = new long[n];
        f[0] = nums[0];
        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1] + nums[i];
            if(f[i] % k == 0) {
                return true;
            }
            if(i > 1) {
                for (int j = i - 2; j >= 0; j--) {
                    if((f[i] - f[j]) % k == 0) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public boolean checkSubarraySum2(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) {
            return false;
        }

        // 判断有没有连续的两个0 因为k*0=0，0是任何数的倍数
        for (int i = 0; i < n - 1; i++) {
            if(nums[i] == 0 && nums[i+1] == 0) {
                return true;
            }
        }

        int i = 0,j = 1,sum = nums[0];

        while(j < n) {
            sum += nums[j];
            if(sum % k == 0) {
                return true;
            }else {
                j++;
            }

            if(j == n) {
                // 第一轮都加完后 若比k小 则后面的更小 跳出循环 ex：[5,1,2] k=9
                if(sum < k) {
                    break;
                }

                i++;
                j = i + 1;
                sum = nums[i];
            }

        }

        return false;
    }

    public boolean checkSubarraySum3(int[] nums, int k) {
        int n = nums.length;
        if(n < 2) {
            return false;
        }

        // 余数
        int r = 0;
        // key 余数； value 下标
        Map<Integer,Integer> map = new HashMap<>();
        // 放个默认的0，因为会有sum[i]刚好是k的倍数的情况 例：0，2，4  k=6
        map.put(0,-1);
        for (int i = 0; i < n; i++) {
            // 前一个的余数部分拿来就好，被整除的部分不要了
            r = (r + nums[i]) % k;
            if(map.containsKey(r)) {
                Integer index = map.get(r);
                // 存在两个sum[i],sum[j]余数相同 即(sum[i] - sum[j])%k=0 并且 i - j >= 2因为子数组长度至少为2
                if((i - index) >= 2) {
                    return true;
                }
            }else {
                map.put(r,i);
            }
        }
        return false;
    }

    public boolean checkSubarraySum4(int[] nums, int k) {//同余定理
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,0);
        int len=nums.length;
        for(int i=1;i<len;i++){
            nums[i]=nums[i]+nums[i-1];
            if(map.containsKey(nums[i]%k)){
                return true;
            }
            map.put(nums[i-1]%k,0);
        }
        return false;
    }

    public static void main(String[] args) {
        CheckSubarraySum obj = new CheckSubarraySum();
        System.out.println(obj.checkSubarraySum4(new int[]{3,2,4},6));
/*        System.out.println(obj.checkSubarraySum3(new int[]{23,2,6,4,7},6));
        System.out.println(obj.checkSubarraySum3(new int[]{23,2,4,6,6},7));
        System.out.println(obj.checkSubarraySum3(new int[]{2,4,3},6));
        System.out.println(obj.checkSubarraySum3(new int[]{23,2,6,4,7},13));*/
    }

}

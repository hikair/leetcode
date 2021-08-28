package com.num;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length; j++) {
                if(nums[i] == nums[j] && i!=j) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                return nums[i];
            }
        }
        return 0;
    }

    public int singleNumber2(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if(map.containsKey(num)) {
                map.remove(num);
            }else {
                map.put(num,0);
            }
        }
        return map.keySet().iterator().next();
    }

    /**
     * 任何数异或0等于本身
     * 任何数异或自己等于0
     * 异或满足交换律和结合律
     * 把数组里全部异或一遍等于答案
     * @param nums
     * @return
     */
    public int singleNumber3(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber3(new int[]{2,2,4,3,3}));
    }
}

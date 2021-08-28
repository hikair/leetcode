package com.arr;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0,j = 1;
        while(true) {
            // i指向0
            while(i < n && nums[i] != 0) {
                i++;
                j++;
            }
            // j指向非0
            while(j < n && nums[j] == 0) {
                j++;
            }

            if(j >= n) {
                return;
            }

            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j++] = temp;
        }
    }

    public void moveZeroes2(int[] nums) {
        int n = nums.length;
        int l = 0,r = 0;
        while(r < n) {
            if(nums[r] != 0) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
            }
            r++;
        }
    }

    public static void main(String[] args) {
        MoveZeroes obj = new MoveZeroes();
        //int[] arr = new int[]{0,1,0,3,12};
        int[] arr = new int[]{0,1,0,2,3,0};
        obj.moveZeroes2(arr);
        System.out.println(Arrays.toString(arr));
    }
}

package com.arr;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if(digits[n-1] < 9) {
            digits[n-1]++;
            return digits;
        }
        digits[n-1]++;
        for (int i = n - 1; i > 0; i--) {
            if(digits[i] == 10) {
                digits[i] = 0;
                digits[i-1]++;
            }
        }
        if(digits[0] == 10) {
            int[] arr = new int[n+1];
            arr[0] = 1;
            return arr;
        }else {
            return digits;
        }
    }

    public int[] plusOne2(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0 ; i--) {
            digits[i]++;
            digits[i] %= 10;
            if(digits[i]%10 != 0) {
                return digits;
            }
        }
        int[] a = new int[n+1];
        a[0] = 1;
        return a;
    }


    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        //System.out.println(Arrays.toString(plusOne.plusOne(new int[]{0})));
        System.out.println(Arrays.toString(plusOne.plusOne2(new int[]{9,8,7,6,5,4,3,2,1,0})));
        System.out.println(Arrays.toString(plusOne.plusOne2(new int[]{8,9,9})));
        System.out.println(Arrays.toString(plusOne.plusOne2(new int[]{9,9,9})));
        System.out.println(Arrays.toString(plusOne.plusOne2(new int[]{1,0,9})));
        System.out.println(Arrays.toString(plusOne.plusOne2(new int[]{9,8,9})));
        System.out.println(Arrays.toString(plusOne.plusOne2(new int[]{0})));
    }
}

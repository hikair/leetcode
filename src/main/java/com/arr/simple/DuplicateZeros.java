package com.arr.simple;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * <p>
 * 注意：请不要在超过该数组长度的位置写入元素。
 * <p>
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * 示例 2：
 * <p>
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/duplicate-zeros
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        String s = Arrays.stream(arr).boxed().map(e -> "" + e).collect(Collectors.joining("")).replace("0", "00");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.charAt(i) - '0';
        }
    }

    public void duplicateZeros2(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                for (int j = n - 1; j > i + 1; j--) {
                    swap(arr, j);
                }
                if (i + 1 < n) {
                    arr[i + 1] = 0;
                    i++;
                }
            }
        }
    }

    public void swap(int[] arr, int i) {
        int temp = arr[i];
        arr[i] = arr[i - 1];
        arr[i - 1] = temp;
    }
}

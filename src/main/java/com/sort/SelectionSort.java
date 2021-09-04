package com.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 具有不稳定性
 * 例：{5,8,5,2,9} 第一遍选择第1个元素5会和2交换，那么原序列中两个5的相对前后顺序就被破坏了，所以选择排序是一个不稳定的排序算法
 */
public class SelectionSort {

    public void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if(arr[index] > arr[j]) {
                    index = j;
                }
            }
            if(index != i) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,8,5,2,9};
        new SelectionSort().selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

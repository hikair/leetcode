package com.sort;

/**
 * 选择排序，具有不稳定性
 * 一次遍历选择元素最大的下标，与最后一位交换
 */
public class SelectionSort implements SortStrategy {
    @Override
    public void sortArr(int[] arr) {
        int n = arr.length;
        for (int i = n - 1; i > 0; i--) {
            int m = i;
            for (int j = 0; j < i; j++) {
                if (arr[m] < arr[j]) {
                    m = j;
                }
            }
            swap(arr, m, i);
        }
    }
}

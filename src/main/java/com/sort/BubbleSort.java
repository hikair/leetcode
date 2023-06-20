package com.sort;

/**
 * 冒泡排序
 * 每次比较相邻元素，大的往右移，这样一次遍历下来最大元素必定会移到最后一位
 */
public class BubbleSort implements SortStrategy {
    @Override
    public void sortArr(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean f = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    f = false;
                }
            }
            // 一次没有交换过，说明已经排序好了，直接退出
            if (f) {
                break;
            }
        }
    }
}

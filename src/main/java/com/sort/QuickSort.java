package com.sort;

/**
 * 快速排序
 * 分治思想，选取一个基准值base，比基准值小的排在左边，大的排在右边，这样就有了左右两个序列，对左右两边做同样的操作就能实现排序
 */
public class QuickSort implements SortStrategy {
    @Override
    public void sortArr(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int l = low, r = high, base = arr[low];
        while (l < r) {
            while (l < r && arr[r] >= base) {
                r--;
            }
            while (l < r && arr[l] <= base) {
                l++;
            }
            swap(arr, l, r);
        }
        // 基准值交换，上面循环是右哨兵先移动，r的位置必定比基准值小
        swap(arr, low, l);
        sort(arr, low, l - 1);
        sort(arr, r + 1, high);
    }
}

package com.sort;

/**
 * 快速排序
 */
public class QuickSort {

    public void quickSort(int[] arr) {
        qSort(arr, 0, arr.length - 1);
    }

    public void qSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int l = low, r = high, base = arr[low];
        while(l < r) {
            while(l < r && arr[r] >= base) {
                r--;
            }
            while(l < r && arr[l] <= base) {
                l++;
            }
            swap(arr, l, r);
        }
        // 上面循环是右哨兵先移动，r的位置必定比基准值小
        swap(arr, low, r);
        qSort(arr, low, l - 1);
        qSort(arr, r + 1, high);
    }

    public void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}

package com.sort;

public interface SortStrategy {
    void sortArr(int[] arr);

    default void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

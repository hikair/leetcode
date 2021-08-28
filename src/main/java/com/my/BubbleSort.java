package com.my;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < n - 1 - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                    flag = false;
                }
            }
            // 一次没有交换过，说明已经排序好了，直接退出
            if(flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,1,2,5,7,4,6};
        new BubbleSort().bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}

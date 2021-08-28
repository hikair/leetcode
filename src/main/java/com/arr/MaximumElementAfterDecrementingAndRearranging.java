package com.arr;

import java.util.Arrays;

public class MaximumElementAfterDecrementingAndRearranging {

   public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
       Arrays.sort(arr);
       int n = arr.length;
        arr[0] = 1;
       for (int i = 1; i < n; i++) {
           if(arr[i] > arr[i-1] + 1) {
               arr[i] = arr[i - 1] + 1;
           }
       }
       return arr[n - 1];
   }

    public static void main(String[] args) {
        MaximumElementAfterDecrementingAndRearranging obj = new MaximumElementAfterDecrementingAndRearranging();
        System.out.println(obj.maximumElementAfterDecrementingAndRearranging(new int[]{2,2,1,2,1}));
        System.out.println(obj.maximumElementAfterDecrementingAndRearranging(new int[]{1,2,2,2,5}));
        System.out.println(obj.maximumElementAfterDecrementingAndRearranging(new int[]{1,100,1000}));
        System.out.println(obj.maximumElementAfterDecrementingAndRearranging(new int[]{1,2,3,4,5}));
    }
}

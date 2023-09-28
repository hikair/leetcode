package com.binarysearch.hard;

import java.util.Arrays;

/**
 * 2251. 花期内花的数目
 */
public class FullBloomFlowers {

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = flowers[i][0];
            ends[i] = flowers[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int[] ans = new int[people.length];

        for (int i = 0; i < people.length; i++) {
            ans[i] = binarySearch(starts, people[i] + 1) - binarySearch(ends, people[i]);
        }
        return ans;
    }

    public int binarySearch(int[] arr, int target) {
        // >= target的最小下标，若不存在返回n
        int l = -1, r = arr.length;
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (target > arr[m]) {
                l = m; // [m, r]
            } else {
                r = m; // [l, m]
            }
        }
        return r;
    }
}

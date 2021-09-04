package com.arr;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * 示例：
 *
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 *
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-k-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SmallestK {

    public int[] smallestK(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }

    /**
     * 优先队列
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK2(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : arr) {
            priorityQueue.offer(num);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll();
        }
        return res;
    }

    /**
     * 快速排序
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK3(int[] arr, int k) {

        int[] res = new int[k];
        return res;
    }

    public void qSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int l = low, r = high;
        int baseIndex = new Random().nextInt(r - l + 1) + l;
        int base = arr[baseIndex];
        swap(arr, l, base);
        while(l < r) {
            while(l < r && arr[r] >= base) {
                r--;
            }
            while(l < r && arr[l] <= base) {
                l++;
            }
            swap(arr, l, r);
        }
    }

    public void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}

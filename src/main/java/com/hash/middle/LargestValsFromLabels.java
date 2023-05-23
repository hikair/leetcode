package com.hash.middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1090. 受标签影响的最大值
 * <p>
 * 我们有一个 n 项的集合。给出两个整数数组 values 和 labels ，第 i 个元素的值和标签分别是 values[i] 和 labels[i]。还会给出两个整数 numWanted 和 useLimit 。
 * <p>
 * 从 n 个元素中选择一个子集 s :
 * <p>
 * 子集 s 的大小 小于或等于 numWanted 。
 * s 中 最多 有相同标签的 useLimit 项。
 * 一个子集的 分数 是该子集的值之和。
 * <p>
 * 返回子集 s 的最大 分数 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：values = [5,4,3,2,1], labels = [1,1,2,2,3], numWanted = 3, useLimit = 1
 * 输出：9
 * 解释：选出的子集是第一项，第三项和第五项。
 * 示例 2：
 * <p>
 * 输入：values = [5,4,3,2,1], labels = [1,3,3,3,2], numWanted = 3, useLimit = 2
 * 输出：12
 * 解释：选出的子集是第一项，第二项和第三项。
 * 示例 3：
 * <p>
 * 输入：values = [9,8,8,7,6], labels = [0,0,0,1,1], numWanted = 3, useLimit = 1
 * 输出：16
 * 解释：选出的子集是第一项和第四项。
 *  
 * <p>
 * 提示：
 * <p>
 * n == values.length == labels.length
 * 1 <= n <= 2 * 10^4
 * 0 <= values[i], labels[i] <= 2 * 10^4
 * 1 <= numWanted, useLimit <= n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/largest-values-from-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestValsFromLabels {

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids, (o1, o2) -> values[o2] - values[o1]);
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;
        for (Integer id : ids) {
            Integer v = map.getOrDefault(labels[id], 0);
            if (v < useLimit) {
                sum += values[id];
                map.put(labels[id], v + 1);
                count++;
            }
            if (count >= numWanted) {
                break;
            }
        }
        return sum;
    }

    public int largestValsFromLabels2(int[] values, int[] labels, int numWanted, int useLimit) {
        sort(values, labels);
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;
        for (int i = 0; i < values.length && count < numWanted; i++) {
            Integer v = map.getOrDefault(labels[i], 0);
            if (v < useLimit) {
                sum += values[i];
                map.put(labels[i], v + 1);
                count++;
            }
        }
        return sum;
    }

    private void sort(int[] values, int[] labels) {
        int n = values.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (values[j] < values[j + 1]) {
                    swap(values, j, j + 1);
                    swap(labels, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

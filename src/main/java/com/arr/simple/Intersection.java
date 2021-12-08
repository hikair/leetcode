package com.arr.simple;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 *
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            for (int j : nums2) {
                if (i == j) {
                    set.add(i);
                }
            }
        }
        int[] res = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            res[i++] = iterator.next();
        }
        return res;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                set2.add(i);
            }
        }
        int[] res = new int[set2.size()];
        Iterator<Integer> iterator = set2.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            res[i++] = iterator.next();
        }
        return res;
    }

    public int[] intersection3(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).distinct().filter(set::contains).toArray();
    }

    //  其他方法 list的 retainAll可以拿重叠部分数据
}

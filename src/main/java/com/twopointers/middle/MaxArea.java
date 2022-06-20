package com.twopointers.middle;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 * <p>
 * 输入：height = [1,1]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxArea {

    /**
     * 双指针，l指向左边下标，r指向右边节点
     * 算出面积后，每次移动较短的那个下标
     * 证明：
     * 1, 8, 6, 2, 5, 4, 8, 3, 7
     * 如果移动较高的那个下标，那么l, r距离变短，而面积由矮柱子决定，min(l, r)，那么面积必然会减少
     * 所以相当于较小的那个指针与所有其他柱子做了匹配，此时移动较小指针是安全的
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, area = 0;
        while (l < r) {
            boolean f = height[l] > height[r];
            area = Math.max(area, (r - l) * (f ? height[r--] : height[l++]));
        }
        return area;
    }
}

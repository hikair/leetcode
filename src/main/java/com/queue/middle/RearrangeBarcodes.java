package com.queue.middle;

import java.util.*;

/**
 * 1054. 距离相等的条形码
 * <p>
 * 在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。
 * <p>
 * 请你重新排列这些条形码，使其中任意两个相邻的条形码不能相等。 你可以返回任何满足该要求的答案，此题保证存在答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：barcodes = [1,1,1,2,2,2]
 * 输出：[2,1,2,1,2,1]
 * 示例 2：
 * <p>
 * 输入：barcodes = [1,1,1,1,2,2,3,3]
 * 输出：[1,3,1,3,2,1,2,1]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= barcodes.length <= 10000
 * 1 <= barcodes[i] <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/distant-barcodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RearrangeBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        int[] ans = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int barcode : barcodes) {
            map.put(barcode, map.getOrDefault(barcode, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        map.forEach((k, v) -> queue.add(new int[]{v, k}));
        for (int i = 0; i < n; i++) {
            int[] p = queue.poll();
            int cx = p[0], x = p[1];
            if (i == 0 || x != ans[i - 1]) {
                ans[i] = x;
                if (cx > 1) {
                    queue.offer(new int[]{cx - 1, x});
                }
            } else {
                int[] p2 = queue.poll();
                int cy = p2[0], y = p2[1];
                ans[i] = y;
                if (cy > 1) {
                    queue.offer(new int[]{cy - 1, y});
                }
                queue.offer(p);
            }
        }
        return ans;
    }
}

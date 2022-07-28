package com.math.middle;

import java.util.Arrays;

/**
 * 给定2D空间中四个点的坐标 p1, p2, p3 和 p4，如果这四个点构成一个正方形，则返回 true 。
 *
 * 点的坐标 pi 表示为 [xi, yi] 。输入 不是 按任何顺序给出的。
 *
 * 一个 有效的正方形 有四条等边和四个等角(90度角)。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * 输出: True
 * 示例 2:
 *
 * 输入：p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
 * 输出：false
 * 示例 3:
 *
 * 输入：p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
 * 输出：true
 *  
 *
 * 提示:
 *
 * p1.length == p2.length == p3.length == p4.length == 2
 * -10^4 <= xi, yi <= 10^4
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidSquare {

    /**
     * 计算4条边长和2条对角线，如果4条边长相等，2条对角线相等，且长度都大于0，那么它就是正方形
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     * @return
     */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        long[] l = new long[]{len(p1, p2), len(p1, p3), len(p1, p4), len(p2, p3), len(p2, p4), len(p3, p4)};
        Arrays.sort(l);
        return l[0] == l[1] && l[0] == l[2] && l[0] == l[3] && l[4] == l[5] && l[0] > 0;
    }

    private long len(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}

package com.other;

/**
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * 示例 2：
 *
 * 输入：x = 3, y = 1
 * 输出：1
 *  
 *
 * 提示：
 *
 * 0 <= x, y <= 2^31 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hamming-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        return Integer.toBinaryString(x ^ y).replace("0","").length();
    }

    public int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        HammingDistance obj = new HammingDistance();
        System.out.println(obj.hammingDistance2(1, 4));//2
        System.out.println(obj.hammingDistance2(3, 1));//1
        System.out.println(obj.hammingDistance2(9, 11));
    }
}

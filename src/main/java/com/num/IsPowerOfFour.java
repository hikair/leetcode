package com.num;

/**
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 16
 * 输出：true
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：false
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：true
 *  
 *
 * 提示：
 *
 * -2^31 <= n <= 2^31 - 1
 *  
 *
 * 进阶：
 *
 * 你能不使用循环或者递归来完成本题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-four
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPowerOfFour {

    public boolean isPowerOfFour(int n) {
        return (n & (n - 1)) == 0 && n % 3 == 1;
    }

    public boolean isPowerOfFour2(int n) {
        switch (n) {
            case 1:
            case 4:
            case 16:
            case 64:
            case 256:
            case 1024:
            case 4096:
            case 16384:
            case 65536:
            case 262144:
            case 1048576:
            case 4194304:
            case 16777216:
            case 67108864:
            case 268435456:
            case 1073741824:
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IsPowerOfFour isPowerOfFour = new IsPowerOfFour();
        System.out.println(isPowerOfFour.isPowerOfFour(67108864));
    }
}

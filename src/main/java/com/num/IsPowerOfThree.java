package com.num;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 27
 * 输出：true
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：false
 * 示例 3：
 *
 * 输入：n = 9
 * 输出：true
 * 示例 4：
 *
 * 输入：n = 45
 * 输出：false
 *  
 *
 * 提示：
 *
 * -2^31 <= n <= 2^31 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPowerOfThree {

    public boolean isPowerOfThree(int n) {
        return n > 0 && (1162261467 % n == 0);
    }

    public boolean isPowerOfThree3(int n) {
        if(n < 1) {
            return false;
        }

        while(n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public boolean isPowerOfThree2(int n) {
        switch (n) {
            case 1 :
            case 3 :
            case 9 :
            case 27 :
            case 81 :
            case 243 :
            case 729 :
            case 2187 :
            case 6561 :
            case 19683 :
            case 59049 :
            case 177147 :
            case 531441 :
            case 1594323 :
            case 4782969 :
            case 14348907 :
            case 43046721 :
            case 129140163 :
            case 387420489 :
            case 1162261467 :return true;
            default:return false;
        }
    }

    public static void main(String[] args) {
        IsPowerOfThree obj = new IsPowerOfThree();
        System.out.println(obj.isPowerOfThree3(45));
    }
}

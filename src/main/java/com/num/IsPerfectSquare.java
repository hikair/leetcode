package com.num;

/**
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 *
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：num = 16
 * 输出：true
 * 示例 2：
 *
 * 输入：num = 14
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= num <= 2^31 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if(num < 2) {
            return true;
        }
        long left = 2;
        long right = num / 2;
        while(left <= right) {
            long mid = (left + right ) / 2;
            if(mid * mid == num) {
                return true;
            }

            if(mid * mid > num) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IsPerfectSquare obj = new IsPerfectSquare();
        //System.out.println(obj.isPerfectSquare(82));
        System.out.println(obj.isPerfectSquare(808201));
    }
}

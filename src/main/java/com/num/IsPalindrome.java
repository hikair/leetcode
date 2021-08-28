package com.num;

/**
 * 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 *
 * 输入：x = -101
 * 输出：false
 *  
 *
 * 提示：
 *
 * -2^31 <= x <= 2^31 - 1
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPalindrome {

    public boolean isPalindrome(int x) {
        int t = x;
        int y = 0;
        while(t>0) {
            y = y*10 + t%10;
            t /= 10;
        }
        return x == y;
    }

    // 效率最低
    public boolean isPalindrome2(int x) {
        return new StringBuilder("" + x).reverse().toString().equals(""+x);
    }

    //
    public boolean isPalindrome3(int x) {
        if(x<0 || (x%10==0 && x!=0)) {
            return false;
        }
        int y = 0;
        while(y<x) {
            y = y*10 + x%10;
            x /= 10;
        }
        // 11211 y=112,x=11   1221  y=12,x=12
        return x == y || y / 10 == x;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        boolean palindrome = isPalindrome.isPalindrome3(11);
        System.out.println(palindrome);
    }
}

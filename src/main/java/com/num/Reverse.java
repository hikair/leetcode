package com.num;

import java.util.Stack;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 *
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Reverse {

    public int reverse(int x) {
        if(x>-10 && x<10) {
            return x;
        }
        StringBuilder sb = new StringBuilder();
        String str = String.valueOf(Math.abs(x));
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<str.length();i++) {
            stack.add(str.charAt(i));
        }
        for(int i=0;i<str.length();i++) {
            sb.append(stack.pop());
        }
        try {
            int i = Integer.parseInt(sb.toString());
            if(x<0) {
                return -i;
            }
            return i;
        } catch (NumberFormatException e) {
            return 0;
        }
    }


    public int reverse2(int x) {
        int res = 0;
        int last = 0;


        return 0;
    }

    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        int a = 2111111119*10;


        System.out.println(reverse.reverse2(2111111119));
    }
}

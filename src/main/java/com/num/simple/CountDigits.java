package com.num.simple;

/**
 * 2520. 统计能整除数字的位数
 * <p>
 * 给你一个整数 num ，返回 num 中能整除 num 的数位的数目。
 * <p>
 * 如果满足 nums % val == 0 ，则认为整数 val 可以整除 nums 。
 */
public class CountDigits {

    public int countDigits(int num) {
        int t = num, ans = 0;
        while (t > 0) {
            int mod = t % 10;
            if (mod > 0 && num % mod == 0) {
                ans++;
            }
            t /= 10;
        }
        return ans;
    }
}

package com.backtrack.middle;

/**
 * 2698. 求一个整数的惩罚数
 * <p>
 * 给你一个正整数 n ，请你返回 n 的 惩罚数 。
 * <p>
 * n 的 惩罚数 定义为所有满足以下条件 i 的数的平方和：
 * <p>
 * 1 <= i <= n
 * i * i 的十进制表示的字符串可以分割成若干连续子字符串，且这些子字符串对应的整数值之和等于 i 。
 * <p>
 * https://leetcode.cn/problems/find-the-punishment-number-of-an-integer/description/
 */
public class PunishmentNumber {

    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (is(i)) {
                ans += i * i;
            }
        }
        return ans;
    }

    private boolean is(int x) {
        int y = x * x;
        return backTrack(y + "", x, 0, 0);
    }

    private boolean backTrack(String str, int x, int index, int sum) {
        if (index == str.length()) {
            return sum == x;
        }
        if (sum > x) {
            return false;
        }

        for (int i = 1; i <= str.length() - index; i++) {
            String subStr = str.substring(index, index + i);
            int num = Integer.parseInt(subStr);
            sum += num;
            if (backTrack(str, x, index + i, sum)) {
                return true;
            }
            sum -= num;
        }
        return false;
    }
}

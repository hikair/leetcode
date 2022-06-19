package com.str.middle;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *  
 *
 * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class convertZ {

    public String convert(String s, int r) {
        int n = s.length();
        if (r == 1 || r >= n) {
            return s;
        }
        int t = r * 2 - 2;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i += t) {
            ans.append(s.charAt(i));
        }
        for (int i = 1; i < r - 1; i++) {
            for (int j = 0; t * j + i < n; j++) {
                ans.append(s.charAt(t * j + i));
                int temp = (j + 1) * t - i;
                if (temp < n) {
                    ans.append(s.charAt(temp));
                }
            }
        }
        for (int i = r - 1; i < n; i += t) {
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}

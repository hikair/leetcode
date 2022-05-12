package com.str.middle;

/**
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *  
 *
 * 示例 2:
 *
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/one-away-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OneEditAway {

    public boolean oneEditAway(String first, String second) {
        if (first.length() < second.length()) {
            String t = first;
            first = second;
            second = t;
        }
        char[] cs1 = first.toCharArray();
        char[] cs2 = second.toCharArray();
        int len1 = cs1.length, len2 = cs2.length;
        int count = 0;
        for (int i = 0, j = 0; i < len1; i++) {
            if (count > 1) {
                return false;
            }
            if (j >= len2) {
                count++;
                continue;
            }
            if (cs1[i] == cs2[j]) {
                j++;
            } else {
                count++;
                if (len1 == len2) {
                    j++;
                }
            }
        }
        return count < 2;
    }
}

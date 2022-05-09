package com.hash.simple;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *  
 *
 * 提示:
 *
 * 1 <= s.length, t.length <= 5 * 10^4
 * s 和 t 仅包含小写字母
 *  
 *
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsAnagram {

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] cs1 = s.toCharArray();
        char[] cs2 = t.toCharArray();
        Arrays.sort(cs1);
        Arrays.sort(cs2);
        return Arrays.equals(cs1, cs2);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] temp = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            temp[ch - 'a']++;
        }
        chars = t.toCharArray();
        for (char ch : chars) {
            temp[ch - 'a']--;
        }
        return Arrays.stream(temp).noneMatch(e -> e != 0);
    }
}

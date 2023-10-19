package com.str.hard;

import java.util.regex.Pattern;

/**
 * 10. 正则表达式匹配
 * <p>
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * https://leetcode.cn/problems/regular-expression-matching/description/
 */
public class IsMatch {

    public boolean isMatch(String s, String p) {
        p = filter(p);
        return Pattern.matches(p, s);
    }

    private String filter(String p) {
        char[] cs = p.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cs.length - 1; i++) {
            if (cs[i] == '*' && cs[i + 1] == '*') {
                continue;
            }
            sb.append(cs[i]);
        }
        sb.append(cs[cs.length - 1]);
        return sb.toString();
    }
}

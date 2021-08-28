package com.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map = new HashMap<>();
        int n = pattern.length();
        String[] words = s.split(" ");
        // aaa  aa,aa,aa,aa
        if(n != words.length) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            char ch = pattern.charAt(i);
            if(map.containsKey(ch)) {
                String value = map.get(ch);
                if(!value.equals(words[i])) {
                    return false;
                }
            }else {
                if(map.containsValue(words[i])) {
                    return false;
                }
                map.put(ch,words[i]);
            }
        }
        return true;
    }

    public boolean wordPattern2(String pattern, String s) {
        Map<Object,Integer> map = new HashMap<>();
        int n = pattern.length();
        String[] words = s.split(" ");
        // aaa  aa,aa,aa,aa
        if(n != words.length) {
            return false;
        }

        for (Integer i = 0; i < n; i++) {
            char ch = pattern.charAt(i);
            if(map.put(ch,i) != map.put(words[i],i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern obj = new WordPattern();
        System.out.println(obj.wordPattern2("abba","dog cat cat dog"));
        System.out.println(obj.wordPattern2("abba","dog cat cat fish"));
        System.out.println(obj.wordPattern2("aaaa","dog cat cat dog"));
        System.out.println(obj.wordPattern2("abba","dog dog dog dog"));
    }
}

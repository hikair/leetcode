package com.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 *
 * 输入：s = "paper", t = "title"
 * 输出：true
 *  
 *
 * 提示：
 *
 * 可以假设 s 和 t 长度相同。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsIsomorphic {

    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                if(t.charAt(i) != map.get(s.charAt(i))) {
                    return false;
                }
            }else if(map.containsValue(t.charAt(i))) {
                return false;
            }else {
                map.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {

        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        int[] ch1 = new int[256];
        int[] ch2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if(ch1[chs[i]] != ch2[cht[i]]) {
                return false;
            }
            // s和t的每个字符用相同的值对应起来
            ch1[chs[i]] = i + 1;
            ch2[cht[i]] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        IsIsomorphic obj = new IsIsomorphic();
        System.out.println(obj.isIsomorphic2("paper","title"));
        System.out.println(obj.isIsomorphic2("foo","bar"));
        System.out.println(obj.isIsomorphic2("badc","baba"));
    }
}

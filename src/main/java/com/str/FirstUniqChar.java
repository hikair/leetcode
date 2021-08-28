package com.str;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *  
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *  
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FirstUniqChar {

    public int firstUniqChar(String s) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if(s.indexOf(ch[i]) == s.lastIndexOf(ch[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 用数组存储每个字符出现的次数
     * @param s
     * @return
     */
    public int firstUniqChar2(String s) {
        char[] chars = s.toCharArray();
        char[] ch = new char[26];
        for (int i = 0; i < s.length(); i++) {
            ch[chars[i] - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if(ch[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqChar obj = new FirstUniqChar();
        System.out.println(obj.firstUniqChar2("leetcode"));
        System.out.println(obj.firstUniqChar2("loveleetcode"));
        System.out.println(obj.firstUniqChar2("aa"));
    }
}

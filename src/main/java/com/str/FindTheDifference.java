package com.str;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 *
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 *
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindTheDifference {

    public char findTheDifference(String s, String t) {
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        int[] temp = new int[26];
        int n = cht.length;
        for (int i = 0; i < n; i++) {
            temp[cht[i] - 'a']++;
            if(i < n - 1) {
                temp[chs[i] - 'a']--;
            }
        }

        for (int i = 0; i < temp.length; i++) {
            if(temp[i] == 1) {
                return (char)(i + 97);
            }
        }
        return ' ';
    }

    public char findTheDifference2(String s, String t) {
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        int sums = 0, sumt = 0;
        for (char ch : chs) {
            sums += ch;
        }

        for (char c : cht) {
            sumt += c;
        }

        return (char)(sumt - sums);
    }

    public char findTheDifference3(String s, String t) {
        char[] chars = (s + t).toCharArray();
        int res = 0;
        for (char aChar : chars) {
            res ^= aChar;
        }
        return (char)res;
    }

    public static void main(String[] args) {
        FindTheDifference obj = new FindTheDifference();
        System.out.println(obj.findTheDifference3("ae","aea"));
        System.out.println(obj.findTheDifference3("","y"));
        System.out.println(obj.findTheDifference3("a","aa"));
        System.out.println(obj.findTheDifference3("abcd","abcde"));
    }
}

package com.str;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："hello"
 * 输出："holle"
 * 示例 2：
 *
 * 输入："leetcode"
 * 输出："leotcede"
 *  
 *
 * 提示：
 *
 * 元音字母不包含字母 "y" 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseVowels {

    public String reverseVowels2(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int i = 0,j = n - 1;
        while(i < j) {
            if(isVowel(ch[i]) && isVowel(ch[j])) {
                char temp = ch[i];
                ch[i++] = ch[j];
                ch[j--] = temp;
            }

            if(!isVowel(ch[i])) {
                i++;
            }

            if(!isVowel(ch[j])) {
                j--;
            }
        }
        return String.valueOf(ch);
    }

    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int i = 0,j = n - 1;
        while(i < j) {
            if(isVowel(ch[i]) && isVowel(ch[j])) {
                char temp = ch[i];
                ch[i++] = ch[j];
                ch[j--] = temp;
            }

            while(i < n && !isVowel(ch[i])) {
                i++;
            }

            while(j >= 0 && !isVowel(ch[j])) {
                j--;
            }
        }
        return String.valueOf(ch);
    }

    public boolean isVowel(char ch) {
        char[] vowel = new char[]{'a','e','i','o','u','A','E','I','O','U'};
        for (char c : vowel) {
            if (ch == c) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ReverseVowels obj = new ReverseVowels();
        System.out.println(obj.reverseVowels2(".,"));
        System.out.println(obj.reverseVowels2("aA"));
        System.out.println(obj.reverseVowels2("hello"));
        System.out.println(obj.reverseVowels2("leetcode"));
    }
}

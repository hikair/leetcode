package com.str;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int[] ch = new int[128];
        for (char aChar : chars) {
            ch[aChar]++;
        }
        int sum = 0;
        boolean flag = false;
        for (int i : ch) {
            if(i > 1) {
                sum += i % 2 == 0 ? i : i - 1;
            }
            if(i % 2 == 1) {
                flag = true;
            }
        }
        return flag ? sum + 1 : sum;
    }

    /**
     * 计算奇数个的个数(没法配对)，加一是因为可以有随便一个放中间
     * @param s
     * @return
     */
    public int longestPalindrome2(String s) {
        int[] ch = new int[128];
        for (char c : s.toCharArray()) {
            ch[c]++;
        }
        int count = 0;
        for (int i : ch) {
            count += i % 2;
        }
        return count == 0 ? s.length() : s.length() - count + 1;
    }

    public static void main(String[] args) {
        LongestPalindrome obj = new LongestPalindrome();
        System.out.println(obj.longestPalindrome2(""));
        System.out.println(obj.longestPalindrome2("bb"));
        System.out.println(obj.longestPalindrome2("abccccdd"));
        System.out.println(obj.longestPalindrome2("ab"));
        System.out.println(obj.longestPalindrome2("ccc"));//3
        System.out.println(obj.longestPalindrome2("cccddd"));//5
    }
}

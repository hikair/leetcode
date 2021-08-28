package com.str;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 *
 * 提示：
 *
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if(strs.length == 0) {
            return "";
        }

        if(strs.length == 1) {
            return strs[0];
        }

        String base = strs[0];

        int right = base.length();
        String str;
        while(right != 0) {
            str = base.substring(0,right);
            // 判断是否都以str开头
            boolean flag = true;
            for (int i = 1; i < strs.length; i++) {
                if(!strs[i].startsWith(str)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                int temp = (right + base.length())/2;
                // 继续循环都是一样的结果
                if(right == temp) {
                    return str;
                }
                right = temp;
            }else {
                // [0,right) 匹配不上，后面截掉
                base = base.substring(0,right);
                right /= 2;
            }

        }

        return "";
    }

    public String longestCommonPrefix2(String[] strs) {
        if(strs.length == 0) {
            return "";
        }

        if(strs.length == 1) {
            return strs[0];
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (;j<prefix.length() && j < strs[i].length(); j++) {
                if(prefix.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            prefix = prefix.substring(0,j);
        }

        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] str = {"flower","flow","flight"};
        //String[] str = {""};
        String s = longestCommonPrefix.longestCommonPrefix2(str);
        System.out.println(s);
    }
}

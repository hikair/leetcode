package com.str;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 *  
 *
 * 提示：
 *
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length()-1, j = num2.length()-1;
        while(i >= 0 || j >= 0 || carry != 0){
            if(i>=0) {
                carry += num1.charAt(i--)-'0';
            }
            if(j>=0) {
                carry += num2.charAt(j--)-'0';
            }
            sb.append(carry%10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }

    public String addStrings2(String num1, String num2) {
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        int sum = 0, i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        // sum != 0 防止num1和num2长度相同时进位没加 例： 1,9  10，90
        while(i >= 0 || j >= 0 || sum != 0) {
            if(i >= 0) {
                sum += ch1[i--] - '0';
            }
            if(j >= 0) {
                sum += ch2[j--] - '0';
            }
            sb.append(sum % 10);
            sum /= 10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddStrings obj = new AddStrings();
        System.out.println(obj.addStrings2("123","123"));
        System.out.println(obj.addStrings2("99","199"));
        System.out.println(obj.addStrings2("1","199"));
        System.out.println(obj.addStrings2("1","9"));
    }
}

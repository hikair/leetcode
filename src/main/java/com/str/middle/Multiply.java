package com.str.middle;

/**
 * https://leetcode.cn/problems/multiply-strings/
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= num1.length, num2.length <= 200
 * num1 和 num2 只能由数字组成。
 * num1 和 num2 都不包含任何前导零，除了数字0本身。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Multiply {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int x = num1.length() - 1;
        StringBuilder result = new StringBuilder();
        for (int y = num2.length() - 1; y >= 0; y--) {
            int carry = 0;
            int py = num2.charAt(y) - '0';
            StringBuilder temp = new StringBuilder();
            for (int i = x; i >= 0; i--) {
                int px = num1.charAt(i) - '0';
                int t = py * px + carry;
                temp.insert(0, t % 10);
                carry = t / 10;
            }
            if (carry > 0) {
                temp.insert(0, carry);
            }
            for (int i = 0; i < num2.length() - y - 1; i++) {
                temp.append("0");
            }
            result = new StringBuilder(addStrings(result.toString(), temp.toString()));
        }
        return result.toString();
    }

    private String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) {
                carry += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += num2.charAt(j--) - '0';
            }
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }
}

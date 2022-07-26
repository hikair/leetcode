package com.str.middle;

/**
 * 给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。 
 * <p>
 * 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: expression = "-1/2+1/2"
 * 输出: "0/1"
 *  示例 2:
 * <p>
 * 输入: expression = "-1/2+1/2+1/3"
 * 输出: "1/3"
 * 示例 3:
 * <p>
 * 输入: expression = "1/3-1/2"
 * 输出: "-1/6"
 *  
 * <p>
 * 提示:
 * <p>
 * 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。 
 * 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。
 * 输入只包含合法的最简分数，每个分数的分子与分母的范围是  [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。
 * 输入的分数个数范围是 [1,10]。
 * 最终结果的分子与分母保证是 32 位整数范围内的有效整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/fraction-addition-and-subtraction
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FractionAddition {

    public String fractionAddition(String expression) {
        long xi = 0, yi = 1;
        int i = 0, n = expression.length();
        char[] cs = expression.toCharArray();
        while (i < n) {
            long x = 0, y = 0, sign = 1;
            if (cs[i] == '-' || cs[i] == '+') {
                sign = cs[i++] == '-' ? -1 : 1;
            }
            while (i < n && Character.isDigit(cs[i])) {
                x = x * 10 + cs[i++] - '0';
            }
            x *= sign;
            i++;
            while (i < n && Character.isDigit(cs[i])) {
                y = y * 10 + cs[i++] - '0';
            }
            xi = xi * y + x * yi;
            yi *= y;
        }
        if (xi == 0) {
            return "0/1";
        }
        long g = gcd(Math.abs(xi), yi);
        return String.format("%d/%d", xi / g, yi / g);
    }

    public long gcd(long a, long b) {
        long remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }
}

package com.math.middle;

/**
 * 1017. 负二进制转换
 * <p>
 * 给你一个整数 n ，以二进制字符串的形式返回该整数的 负二进制（base -2）表示。
 * <p>
 * 注意，除非字符串就是 "0"，否则返回的字符串中不能含有前导零。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出："110"
 * 解释：(-2)2 + (-2)1 = 2
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出："111"
 * 解释：(-2)2 + (-2)1 + (-2)0 = 3
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出："100"
 * 解释：(-2)2 = 4
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 10^9
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/convert-to-base-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BaseNeg2 {
    public String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        while (n != 0) {
            int mod = Math.abs(n % (-2));
            ans.append(mod);
            n = (n - mod) / (-2);
        }
        return ans.reverse().toString();
    }
}

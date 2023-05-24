package com.dp.middle;

/**
 * 交错字符串
 * <p>
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 * <p>
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * <p>
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 注意：a + b 意味着字符串 a 和 b 连接。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：s1 = "", s2 = "", s3 = ""
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= s1.length, s2.length <= 100
 * 0 <= s3.length <= 200
 * s1、s2、和 s3 都由小写英文字母组成
 *  
 * <p>
 * 进阶：您能否仅使用 O(s2.length) 额外的内存空间来解决它?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/interleaving-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsInterleave {

    /**
     * 动态规划
     * s1 = bacc, s2 = aabcce, s3 = abaacbccec
     * 打表
     *     | 0 | a | a | b | c | c | e |
     * | 0 | T | T | F | F | F | F | F |
     * | b | F | T | T | F | F | F | F |
     * | a | F | T | T | F | F | F | F |
     * | c | F | F | T | T | T | T | T |
     * | c | F | F | F | F | T | F | T |
     * 行（i）表示s1的第i个元素
     * 列（j）表示s2的第j个元素
     * dp[i][j] 表示 s1前i个元素与s2前j个元素加在一起是否可以表示s3前i + j个元素
     * 边界：
     * 1.dp[0][0] = true
     * 2.dp[i][0] = s1前i个元素是否是s3前i个元素
     * 3.dp[0][j] = s2前j个元素是否是s3前j个元素
     * 转移方程：
     * dp[i][j] = (dp[i - 1][j] && (s1第i个元素是否是s3当前长度的最后一个元素)) or (dp[i][j - 1] && (s2第j个元素是否是s3当前长度的最后一个元素))
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len1 && s1.charAt(i - 1) == s3.charAt(i - 1); i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= len2 && s2.charAt(i - 1) == s3.charAt(i - 1); i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i][j] = (dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1)))
                        || (dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1)));
            }
        }
        return dp[len1][len2];
    }
}

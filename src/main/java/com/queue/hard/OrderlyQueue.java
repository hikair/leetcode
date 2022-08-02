package com.queue.hard;

import java.util.Arrays;

/**
 * 给定一个字符串 s 和一个整数 k 。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾。
 * <p>
 * 返回 在应用上述步骤的任意数量的移动后，字典上最小的字符串 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "cba", k = 1
 * 输出："acb"
 * 解释：
 * 在第一步中，我们将第一个字符（“c”）移动到最后，获得字符串 “bac”。
 * 在第二步中，我们将第一个字符（“b”）移动到最后，获得最终结果 “acb”。
 * 示例 2：
 * <p>
 * 输入：s = "baaca", k = 3
 * 输出："aaabc"
 * 解释：
 * 在第一步中，我们将第一个字符（“b”）移动到最后，获得字符串 “aacab”。
 * 在第二步中，我们将第三个字符（“c”）移动到最后，获得最终结果 “aaabc”。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= S.length <= 1000
 * s 只由小写字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/orderly-queue
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OrderlyQueue {

    /**
     * 分成两种情况：k = 1 和 k > 1
     * 当k = 1，只需要判断n个字符串即可
     * 当k > 1，s必定可以重新排序成有序，直接升序后的结果即可
     * @param s
     * @param k
     * @return
     */
    public String orderlyQueue(String s, int k) {
        String ans = s;
        if (k == 1) {
            for (int i = 1; i < s.length(); i++) {
                s = s.substring(1) + s.substring(0, 1);
                if (ans.compareTo(s) > 0) {
                    ans = s;
                }
            }
            return ans;
        }
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        return String.valueOf(cs);
    }
}

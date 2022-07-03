package com.num.middle;

/**
 * 给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
 * <p>
 * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：21
 * 示例 2：
 * <p>
 * 输入：n = 21
 * 输出：-1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 2^31 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/next-greater-element-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextGreaterElement {

    public int nextGreaterElement(int n) {
        char[] cs = String.valueOf(n).toCharArray();
        int l = cs.length, a = -1;
        for (int i = l - 1; i > 0; i--) {
            if (cs[i] - cs[i - 1] > 0) {
                a = i - 1;
                break;
            }
        }
        if (a < 0) {
            return -1;
        }
        for (int i = l - 1; i > a; i--) {
            if (cs[i] - cs[a] > 0) {
                swap(cs, i ,a);
                break;
            }
        }
        for (int i = a + 1, j = l - 1; i < j; i++, j--) {
            swap(cs, i, j);
        }
        long ans = Long.parseLong(String.valueOf(cs));
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }

    private void swap(char[] cs, int i, int j) {
        char t = cs[i];
        cs[i] = cs[j];
        cs[j] = t;
    }
}

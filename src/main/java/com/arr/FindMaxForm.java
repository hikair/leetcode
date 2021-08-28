package com.arr;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * 示例 2：
 *
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 *  
 *
 * 提示：
 *
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] 仅由 '0' 和 '1' 组成
 * 1 <= m, n <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ones-and-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMaxForm {

    /**
     * xn为strs下标为n的0的个数，yn为1的个数
     * ① x1+x2+..+xn <= m
     * ② y1+y2+..+yn <= n
     * ③ x1+y1+x2+y2+..xn+yn <= m+n
     * 只有③式成立是不对的，①和②要都成立
     * 即，③成立，①或②有可能不成立。 例：00,000   m=1,n=10
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[] temp = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            temp[i] = strs[i].length();
        }
        Arrays.sort(temp);
        int sum = 0, count = 0;
        for (int i : temp) {
            sum += i;
            if(sum > m + n) {
                return count;
            }
            count++;
        }
        return count;
    }

    public int findMaxForm2(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (String str : strs) {
            int zeros = 0, ones = 0;
            for (char c : str.toCharArray()) {
                if(c == '0') {
                    zeros++;
                }else {
                    ones++;
                }
            }

            for (int i = m; i >= zeros ; i--) {
                for (int j = n; j >= ones ; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        FindMaxForm obj = new FindMaxForm();
        System.out.println(obj.findMaxForm2(new String[]{"111","1000","1000","1000"},9,3));// 3
        System.out.println(obj.findMaxForm2(new String[]{"10","0001","111001","1","0"},5,3));// 4
        System.out.println(obj.findMaxForm2(new String[]{"10","0","1"},1,1)); // 2
        System.out.println(obj.findMaxForm2(new String[]{"00","000"},1,10)); //0 最多一个0
        System.out.println(obj.findMaxForm2(new String[]{"01","01","11"},0,2)); //1
    }
}

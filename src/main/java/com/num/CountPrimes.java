package com.num;

import java.util.Arrays;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：0
 *  
 *
 * 提示：
 *
 * 0 <= n <= 5 * 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-primes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountPrimes {

    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }


    /**
     * 埃氏筛
     * @param n
     * @return
     */
    public int countPrimes2(int n) {
        int[] res = new int[n];
        // 1是质数，0是合数
        Arrays.fill(res,1);
        int sum = 0;
        for (int i = 2; i < n; i++) {
            if(res[i] == 1) {
                sum++;
                if((long)i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        // 4,6,8,10...
                        // 9,12,15,18,21...
                        res[j] = 0;
                    }
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        CountPrimes obj = new CountPrimes();
        System.out.println(obj.countPrimes2(10000));
    }
}

package com.num;

import java.util.HashSet;
import java.util.Set;

/**
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 *
 * 给定一个 整数 n， 如果是完美数，返回 true，否则返回 false
 *
 *  
 *
 * 示例 1：
 *
 * 输入：28
 * 输出：True
 * 解释：28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, 和 14 是 28 的所有正因子。
 * 示例 2：
 *
 * 输入：num = 6
 * 输出：true
 * 示例 3：
 *
 * 输入：num = 496
 * 输出：true
 * 示例 4：
 *
 * 输入：num = 8128
 * 输出：true
 * 示例 5：
 *
 * 输入：num = 2
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= num <= 10^8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckPerfectNumber {

    public boolean checkPerfectNumber(int num) {
        int sum = 1;
        int i = 2, j = num / 2;
        while(i < j) {
            if(num % i == 0) {
                sum += i;
                sum += num / i;
                j = Math.min(j, num / i);
            }
            i++;
        }
        return num != 1 && num == sum;
    }

    public boolean checkPerfectNumber2(int num) {
        int sum = 1;
        for (int i = 2; i < Math.sqrt(num); i++) {
            if(num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        return num != 1 && num == sum;
    }

    public static void main(String[] args) {
        CheckPerfectNumber obj = new CheckPerfectNumber();
        System.out.println(obj.checkPerfectNumber2(1));
        System.out.println(obj.checkPerfectNumber2(2));
        System.out.println(obj.checkPerfectNumber2(28));
        System.out.println(obj.checkPerfectNumber2(496));
        System.out.println(obj.checkPerfectNumber2(8128));
        System.out.println(obj.checkPerfectNumber2(8129));
    }
}

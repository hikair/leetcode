package com.other;

/**
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 *
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 *
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 *
 * 示例 1:
 *
 * n = 5
 *
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 *
 * 因为第三行不完整，所以返回2.
 * 示例 2:
 *
 * n = 8
 *
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 *
 * 因为第四行不完整，所以返回3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arranging-coins
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ArrangeCoins {

    /**
     * 超时
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        int i = 0, sum = 0;
        while(sum <= n) {
            i++;
            sum += i;
        }
        return i - 1;
    }

    public int arrangeCoins2(long n) {
        double num = (Math.sqrt(1 + 8 * n) - 1) / 2;
        return (int) Math.floor(num);
    }

    public int arrangeCoins3(long n) {
        long left = 0, right = n, temp = 0;
        while(left <= right) {
            long mid = left + (right - left) / 2;
            if(mid * mid + mid > 2 * n) {
                right = mid - 1;
            }else {
                left = mid + 1;
                temp = mid;
            }
        }
        return (int) temp;
    }

    public static void main(String[] args) {
        ArrangeCoins obj = new ArrangeCoins();
        System.out.println(obj.arrangeCoins3(2147483647));//65535
        System.out.println(obj.arrangeCoins3(0));//0
        System.out.println(obj.arrangeCoins3(1));//1
        System.out.println(obj.arrangeCoins3(3));//2
        System.out.println(obj.arrangeCoins3(5));//2
        System.out.println(obj.arrangeCoins3(8));//3
    }
}

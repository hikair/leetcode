package com.num;

import java.util.ArrayList;
import java.util.List;

/**
 * 自除数 是指可以被它包含的每一位数除尽的数。
 *
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 *
 * 还有，自除数不允许包含 0 。
 *
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 *
 * 示例 1：
 *
 * 输入：
 * 上边界left = 1, 下边界right = 22
 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * 注意：
 *
 * 每个输入参数的边界满足 1 <= left <= right <= 10000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/self-dividing-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int t = i;
            boolean flag = true;
            while(t > 0) {
                int n = t % 10;
                if(n == 0) {
                    flag = false;
                    break;
                }
                if(i % n != 0) {
                    flag = false;
                    break;
                }
                t /= 10;
            }
            if(flag) {
                list.add(i);
            }
        }
        return list;
    }

    public List<Integer> selfDividingNumbers3(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int t = i;
            while(t > 0) {
                if(t % 10 == 0 || i % (t % 10) != 0) {
                    break;
                }
                t /= 10;
            }
            if(t == 0) {
                list.add(i);
            }
        }
        return list;
    }

    public List<Integer> selfDividingNumbers2(int left, int right) {
        List<Integer> list = new ArrayList<>((right - left) / 2);
        main:
        for (int i = left; i <= right; i++) {
            int num = i;
            while (num > 0) {
                if (0 == num % 10 || i % (num % 10) != 0) {
                    continue main;
                }
                num = num / 10;
            }
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        SelfDividingNumbers obj = new SelfDividingNumbers();
        System.out.println(obj.selfDividingNumbers3(100,128));
    }
}

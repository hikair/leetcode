package com.arr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 *
 * (注：分数越高的选手，排名越靠前。)
 *
 * 示例 1:
 *
 * 输入: [5, 4, 3, 2, 1]
 * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
 * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 * 提示:
 *
 * N 是一个正整数并且不会超过 10000。
 * 所有运动员的成绩都不相同。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-ranks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindRelativeRanks {

    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            switch (n - score[i]) {
                case 0 : res[i] = "Gold Medal";break;
                case 1 : res[i] = "Silver Medal";break;
                case 2 : res[i] = "Bronze Medal";break;
                default: res[i] = String.valueOf(i + 1);break;
            }
        }
        return res;
    }

    public String[] findRelativeRanks2(int[] score) {
        int n = score.length;
        String[] res = new String[n];
        int[] temp = score.clone();
        // 从小到大排序
        Arrays.sort(score);

        Map<Integer,String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String value = "";
            if(i == n - 1) {
                value = "Gold Medal";
            } else if(i == n - 2) {
                value = "Silver Medal";
            } else if(i == n - 3) {
                value = "Bronze Medal";
            } else {
                value = String.valueOf(n - i);
            }
            map.put(score[i], value);
        }

        for (int i = 0; i < n; i++) {
            res[i] = map.get(temp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        FindRelativeRanks obj = new FindRelativeRanks();
        System.out.println(Arrays.toString(obj.findRelativeRanks2(new int[]{2,0})));
        System.out.println(Arrays.toString(obj.findRelativeRanks2(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(obj.findRelativeRanks2(new int[]{10,3,8,9,4})));//["Gold Medal","5","Bronze Medal","Silver Medal","4"]
    }
}

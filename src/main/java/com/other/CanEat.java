package com.other;

import java.util.Arrays;

/**
 * 给你一个下标从 0 开始的正整数数组 candiesCount ，其中 candiesCount[i] 表示你拥有的第 i 类糖果的数目。同时给你一个二维数组 queries ，其中 queries[i] = [favoriteTypei, favoriteDayi, dailyCapi] 。
 *
 * 你按照如下规则进行一场游戏：
 *
 * 你从第 0 天开始吃糖果。
 * 你在吃完 所有 第 i - 1 类糖果之前，不能 吃任何一颗第 i 类糖果。
 * 在吃完所有糖果之前，你必须每天 至少 吃 一颗 糖果。
 * 请你构建一个布尔型数组 answer ，满足 answer.length == queries.length 。answer[i] 为 true 的条件是：在每天吃 不超过 dailyCapi 颗糖果的前提下，你可以在第 favoriteDayi 天吃到第 favoriteTypei 类糖果；否则 answer[i] 为 false 。注意，只要满足上面 3 条规则中的第二条规则，你就可以在同一天吃不同类型的糖果。
 *
 * 请你返回得到的数组 answer 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：candiesCount = [7,4,5,3,8], queries = [[0,2,2],[4,2,4],[2,13,1000000000]]
 * 输出：[true,false,true]
 * 提示：
 * 1- 在第 0 天吃 2 颗糖果(类型 0），第 1 天吃 2 颗糖果（类型 0），第 2 天你可以吃到类型 0 的糖果。
 * 2- 每天你最多吃 4 颗糖果。即使第 0 天吃 4 颗糖果（类型 0），第 1 天吃 4 颗糖果（类型 0 和类型 1），你也没办法在第 2 天吃到类型 4 的糖果。换言之，你没法在每天吃 4 颗糖果的限制下在第 2 天吃到第 4 类糖果。
 * 3- 如果你每天吃 1 颗糖果，你可以在第 13 天吃到类型 2 的糖果。
 * 示例 2：
 *
 * 输入：candiesCount = [5,2,6,4,1], queries = [[3,1,2],[4,10,3],[3,10,100],[4,100,30],[1,3,1]]
 * 输出：[false,true,true,false,false]
 *  
 *
 * 提示：
 *
 * 1 <= candiesCount.length <= 105
 * 1 <= candiesCount[i] <= 105
 * 1 <= queries.length <= 105
 * queries[i].length == 3
 * 0 <= favoriteTypei < candiesCount.length
 * 0 <= favoriteDayi <= 109
 * 1 <= dailyCapi <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanEat {

    public boolean[] canEat(int[] candiesCount, int[][] queries) {

        boolean[] res = new boolean[queries.length];

        // sum[x] 表示第x天之前所有的糖果
        long[] sum = new long[candiesCount.length];
        sum[0] = candiesCount[0];

        for (int i = 1; i < candiesCount.length; i++) {
            sum[i] = sum[i-1] + candiesCount[i];
        }

        for (int i = 0; i < queries.length; i++) {
            int type = queries[i][0];
            int day = queries[i][1];
            int eatNum = queries[i][2];

            // 吃的糖的数量  [day + 1, eatNum * (day + 1)] 类型type糖果的数量范围  [sum[type - 1] + 1, sum[type]]
            // 只要'吃的糖的数量'区间和'类型type糖果的数量范围'区间有交集就好了
            // type=0时数组越界，特殊处理

            long x1 = day + 1;
            // 注意可能溢出，需要强转！！！
            long y1 = (long)eatNum * (day + 1);
            long x2 = type == 0 ? 1 : (sum[type - 1] + 1);
            long y2 = sum[type];

            res[i] = !(x1 > y2 || x2 > y1);
        }
        return res;
    }

    public static void main(String[] args) {
        CanEat obj = new CanEat();
        int[] candiesCount = new int[]{7,4,5,3,8};
        int[][] queries = new int[3][3];
        queries[0] = new int[]{0,2,2};
        queries[1] = new int[]{4,2,4};
        queries[2] = new int[]{2,13,100000000};
        System.out.println(Arrays.toString(obj.canEat(candiesCount, queries)));

        int[] candiesCount2 = new int[]{5,2,6,4,1};
        int[][] queries2 = new int[5][3];
        queries2[0] = new int[]{3,1,2};
        queries2[1] = new int[]{4,10,3};
        queries2[2] = new int[]{3,10,100};
        queries2[3] = new int[]{4,100,30};
        queries2[4] = new int[]{1,3,1};
        System.out.println(Arrays.toString(obj.canEat(candiesCount2, queries2)));
    }
}

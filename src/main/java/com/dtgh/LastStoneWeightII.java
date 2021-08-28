package com.dtgh;

/**
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 *
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：stones = [2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * 示例 2：
 *
 * 输入：stones = [31,26,33,21,40]
 * 输出：5
 * 示例 3：
 *
 * 输入：stones = [1,2]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/last-stone-weight-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LastStoneWeightII {

    /**
     * 设石头为a,b,c,d
     * a - b - ( c - d) = a - b - c + d
     * 在stones每个数前加+或-
     * 设-的石头为加起来重量为neg，总的石头重量为sum，则+的石头的加起来为sum - neg
     * 最后剩下的石头重量为 sum - neg - neg = sum - 2*neg
     * neg应当等于不大于sum / 2 的最大值
     * dp[i][j] 表示有i件物品，背包容量为j的情况下的最大值
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        int  n  = stones.length, sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int l = sum / 2;
        int[][] dp = new int[n+1][l+1];
        for (int i = 1; i < n + 1; i++) {
            int x = stones[i-1];
            for (int j = 0; j < l + 1; j++) {
                if(j < stones[i - 1]) {
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-x] + x);
                }
            }
        }
        return Math.abs(sum - dp[n][l] * 2);
    }

    public static void main(String[] args) {
        LastStoneWeightII obj = new LastStoneWeightII();
        System.out.println(obj.lastStoneWeightII(new int[]{2,7,4,1,8,1}));
        System.out.println(obj.lastStoneWeightII(new int[]{31,26,33,21,40}));
    }
}

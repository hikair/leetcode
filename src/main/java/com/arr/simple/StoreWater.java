package com.arr.simple;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/o8SXZn/
 * <p>
 * 给定 N 个无限容量且初始均空的水缸，每个水缸配有一个水桶用来打水，第 i 个水缸配备的水桶容量记作 bucket[i]。小扣有以下两种操作：
 * <p>
 * 升级水桶：选择任意一个水桶，使其容量增加为 bucket[i]+1
 * 蓄水：将全部水桶接满水，倒入各自对应的水缸
 * 每个水缸对应最低蓄水量记作 vat[i]，返回小扣至少需要多少次操作可以完成所有水缸蓄水要求。
 * <p>
 * 注意：实际蓄水量 达到或超过 最低蓄水量，即完成蓄水要求。
 * <p>
 * 示例 1：
 * <p>
 * 输入：bucket = [1,3], vat = [6,8]
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * 第 1 次操作升级 bucket[0]；
 * 第 2 ~ 4 次操作均选择蓄水，即可完成蓄水要求。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：bucket = [9,0,1], vat = [0,2,2]
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * 第 1 次操作均选择升级 bucket[1]
 * 第 2~3 次操作选择蓄水，即可完成蓄水要求。
 * <p>
 * 提示：
 * <p>
 * 1 <= bucket.length == vat.length <= 100
 * 0 <= bucket[i], vat[i] <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/o8SXZn
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StoreWater {

    public int storeWater(int[] bucket, int[] vat) {
        int n = bucket.length, ans = Integer.MAX_VALUE;
        if (Arrays.stream(vat).allMatch(e -> e == 0)) {
            return 0;
        }
        // 最后蓄水操作k次，没缸需要每次倒入的量 mi = 缸最小容量 / k，不能整除要 + 1
        // 那么所有桶容量要升级的次数要加在一起，updateCount
        for (int k = 1; k < ans; k++) {
            int updateCount = 0;
            for (int i = 0; i < n; i++) {
                if (vat[i] > 0) {
                    updateCount += Math.max(0, getAmount(vat[i], k) - bucket[i]);
                }
            }
            ans = Math.min(ans, updateCount + k);
        }
        return ans;
    }

    private int getAmount(int a, int b) {
        if (a % b == 0) {
            return a / b;
        }
        return a / b + 1;
    }
}

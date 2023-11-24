package com.twopointers.simple;

import java.util.List;

/**
 * 2824. 统计和小于目标的下标对数目
 */
public class CountPairs {

    public int countPairs(List<Integer> nums, int target) {
        nums.sort(Integer::compareTo);
        int n = nums.size(), ans = 0;
        if (n == 1) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    ans++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}

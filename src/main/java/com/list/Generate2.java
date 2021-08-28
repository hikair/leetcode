package com.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Generate2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer>[] dp = new List[rowIndex + 1];
        dp[0] = Collections.singletonList(1);

        for (int i = 1; i <= rowIndex; i++) {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(1);
            for (int j = 0; j < dp[i - 1].size() - 1; j++) {
                res.add(dp[i - 1].get(j) + dp[i - 1].get(j + 1));
            }
            res.add(1);
            dp[i] = res;
        }

        return dp[rowIndex];
    }

    public static void main(String[] args) {
        Generate2 obj = new Generate2();
        System.out.println(obj.getRow(0));
    }
}

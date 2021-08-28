package com.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。



 在杨辉三角中，每个数是它左上方和右上方的数的和。

 示例:

 输入: 5
 输出:
 [
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
public class Generate {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<>();

        List<Integer>[] dp = new List[numRows];
        dp[0] = Collections.singletonList(1);

        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(1);
            for (int j = 0; j < dp[i - 1].size() - 1; j++) {
                res.add(dp[i - 1].get(j) + dp[i - 1].get(j + 1));
            }
            res.add(1);
            dp[i] = res;
        }

        list.addAll(Arrays.asList(dp));
        return list;
    }

    public static void main(String[] args) {
        Generate obj = new Generate();
        System.out.println(obj.generate(5));
    }
}

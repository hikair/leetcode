package com.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 *
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
 *
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: candidates = [2,3,6,7], target = 7
 * 输出: [[7],[2,2,3]]
 * 示例 2：
 *
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 *
 * 输入: candidates = [2], target = 1
 * 输出: []
 * 示例 4：
 *
 * 输入: candidates = [1], target = 1
 * 输出: [[1]]
 * 示例 5：
 *
 * 输入: candidates = [1], target = 2
 * 输出: [[1,1]]
 *  
 *
 * 提示：
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum {

    List<List<Integer>> result = new ArrayList<>();

    List<Integer> path = new ArrayList<>();

    int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return result;
    }

    public void backtracking(int[] arr, int target, int startIndex) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < arr.length && arr[i] + sum <= target; i++) {
            sum += arr[i];
            path.add(arr[i]);
            backtracking(arr, target, i);
            sum -= arr[i];
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(new CombinationSum().combinationSum(new int[]{1, 2}, 1));
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 5}, 8));
        System.out.println(new CombinationSum().combinationSum(new int[]{2}, 1));
        System.out.println(new CombinationSum().combinationSum(new int[]{1}, 1));
        System.out.println(new CombinationSum().combinationSum(new int[]{1}, 2));
    }
}

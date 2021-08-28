package com.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 注意：解集不能包含重复的组合。 
 *
 *  
 *
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 *  
 *
 * 提示:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum2 {

    List<List<Integer>> result = new ArrayList<>();

    List<Integer> path = new ArrayList<>();

    boolean[] used;

    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        used = new boolean[candidates.length];
        backtracking(candidates, target, 0);
        return result;
    }

    public void backtracking(int[] arr, int target, int startIndex) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        if(sum > target) {
            return;
        }

        for (int i = startIndex; i < arr.length && arr[i] + sum <= target; i++) {
            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(arr[i]);
            used[i] = true;
            sum += arr[i];
            backtracking(arr, target, i + 1);
            used[i] = false;
            sum -= arr[i];
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum2().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
        System.out.println(new CombinationSum2().combinationSum2(new int[]{2,5,2,1,2}, 5));
    }
}

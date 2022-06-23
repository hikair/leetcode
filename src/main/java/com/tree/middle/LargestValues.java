package com.tree.middle;

import com.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 在每个树行中找最大值
 * https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
 */
public class LargestValues {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        dfs(ans, root, 0);
        return ans;
    }

    private void dfs(List<Integer> ans, TreeNode node, int height) {
        if (ans.size() == height) {
            ans.add(node.val);
        } else {
            ans.set(height, Math.max(ans.get(height), node.val));
        }
        if (node.left != null) {
            dfs(ans, node.left, height + 1);
        }
        if (node.right != null) {
            dfs(ans, node.right, height + 1);
        }
    }
}

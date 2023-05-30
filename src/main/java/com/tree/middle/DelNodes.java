package com.tree.middle;

import com.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 1110. 删点成林
 * <p>
 * 给出二叉树的根节点 root，树上每个节点都有一个不同的值。
 * <p>
 * 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 * <p>
 * 返回森林中的每棵树。你可以按任意顺序组织答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * 输出：[[1,2,null,4],[6],[7]]
 * 示例 2：
 * <p>
 * 输入：root = [1,2,4,null,3], to_delete = [3]
 * 输出：[[1,2,4]]
 *  
 * <p>
 * 提示：
 * <p>
 * 树中的节点数最大为 1000。
 * 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。
 * to_delete.length <= 1000
 * to_delete 包含一些从 1 到 1000、各不相同的值。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/delete-nodes-and-return-forest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DelNodes {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        List<TreeNode> ans = new ArrayList<>();
        dfs(root, true, set, ans);
        return ans;
    }

    public TreeNode dfs(TreeNode node, boolean isRoot, Set<Integer> set, List<TreeNode> ans) {
        if (node == null) {
            return null;
        }
        boolean isDeleted = set.contains(node.val);
        node.left = dfs(node.left, isDeleted, set, ans);
        node.right = dfs(node.right, isDeleted, set, ans);
        if (isDeleted) {
            return null;
        }
        if (isRoot) {
            ans.add(node);
        }
        return node;
    }
}

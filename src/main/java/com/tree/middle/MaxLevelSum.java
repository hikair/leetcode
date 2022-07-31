package com.tree.middle;

import com.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * <p>
 * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 * 示例 2：
 * <p>
 * 输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * 输出：2
 *  
 * <p>
 * 提示：
 * <p>
 * 树中的节点数在 [1, 104]范围内
 * -10^5 <= Node.val <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxLevelSum {

    public int maxLevelSum(TreeNode root) {
        int ans = 1, level = 1, maxSum = root.val;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while(!list.isEmpty()) {
            List<TreeNode> temp = new ArrayList<>();
            int sum = 0;
            for (TreeNode node : list) {
                sum += node.val;
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
                ans = level;
            }
            list = temp;
            level++;
        }
        return ans;
    }
}
